package ru.otus.spring.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.domain.Book;
import ru.otus.spring.rest.dto.BookDto;
import ru.otus.spring.rest.dto.DtoService;
import ru.otus.spring.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final DtoService dtoService;

    @GetMapping("/api/book")
    public List<BookDto> getAllBooks() {
        return dtoService.booksToDto(bookService.getAllBooks());
    }


    @GetMapping("/api/book/{id}")
    public BookDto getBook(@PathVariable("id") long id) {
        return dtoService.bookToDto(bookService.getBookById(id));
    }

    @PostMapping("/api/book/{id}")
    public BookDto editBook(@PathVariable("id") long id, @RequestBody BookDto bookDto) {

        Book book = dtoService.bookDtoToBook(bookDto);
        bookService.saveBook(book);
        return dtoService.bookToDto(bookService.getBookById(id));
    }

    @PostMapping("/api/book")
    public void addBook(@RequestBody BookDto bookDto) {
        Book book = dtoService.bookDtoToBook(bookDto);
        bookService.saveBook(book);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
    }

}
