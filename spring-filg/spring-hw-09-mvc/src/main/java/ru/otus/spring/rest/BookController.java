package ru.otus.spring.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.spring.domain.Book;
import ru.otus.spring.rest.dto.BookDto;
import ru.otus.spring.rest.dto.DtoService;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.BookService;
import ru.otus.spring.service.GenreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final DtoService dtoService;

    @GetMapping("/")
    public String listPage(Model model) {

        List<BookDto> bookDtos = dtoService.booksToDto(bookService.getAllBooks());
        model.addAttribute("books", bookDtos);
        return "book_list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        BookDto bookDto = dtoService.bookToDto(bookService.getBookById(id));
        model.addAttribute("book", bookDto);
        model.addAttribute("genres", genreService.getGenres());
        model.addAttribute("authors", authorService.getAll());
        return "edit_book";
    }

    @PostMapping("/edit")
    public String saveBook(@RequestParam("id") long id, @ModelAttribute("book") BookDto bookDto) {
        Book book = dtoService.bookDtoToBook(bookDto);
        book.setId(id);
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        BookDto book = new BookDto();
        model.addAttribute("book", book);
        model.addAttribute("genres", genreService.getGenres());
        model.addAttribute("authors", authorService.getAll());

        return "add_book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("bookDto") BookDto bookDto) {
        Book book = dtoService.bookDtoToBook(bookDto);
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deletePage(@RequestParam("id") long id, Model model) {
        BookDto bookDto = dtoService.bookToDto(bookService.getBookById(id));
        model.addAttribute("book", bookDto);
        return "del_book";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam("id") long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }

}
