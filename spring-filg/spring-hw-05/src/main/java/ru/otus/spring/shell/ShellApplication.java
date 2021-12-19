package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.BookService;
import ru.otus.spring.service.GenreService;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellApplication {
    private final AuthorService authorService;
    private final BookService bookService;
    private final GenreService genreService;

    @ShellMethod(value = "get book", key = {"getB"})
    public void getBookById(@ShellOption(defaultValue = "1") String id) {

        Book book = bookService.getBookById(Integer.valueOf(id));
        System.out.println(book);
    }

    @ShellMethod(value = "delete book", key = {"delB"})
    public void deleteBookById(@ShellOption(defaultValue = "1") String id) {

        Book book = bookService.getBookById(Integer.valueOf(id));
        bookService.deleteBook(book);
        System.out.println("deleted book: " + book);
    }

    @ShellMethod(value = "delete book", key = {"editB"})
    public void changeBookName(@ShellOption(defaultValue = "1") String id,
                               @ShellOption(defaultValue = "prefix") String newName) {

        Book book = bookService.getBookById(Integer.valueOf(id));
        Book newBook = new Book(book.getId(), newName, book.getAuthor(), book.getGenre());
        bookService.editBook(newBook);
        System.out.println("book was : " + book);
        System.out.println("book now : " + newBook);
    }

    @ShellMethod(value = "add book", key = {"addB"})
    public void addBook() {
        long id = bookService.countBooks() + 1;
        Book book = new Book(id, "Title" + id, authorService.getAuthors().get(0), genreService.getGenres().get(0));
        bookService.addBook(book);
    }

    @ShellMethod(value = "print authors", key = {"getA"})
    public void printAuthors() {
        List<Author> authors = authorService.getAuthors();
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    @ShellMethod(value = "print author's books", key = {"getAB"})
    public void printAuthorsBooks() {
        List<Author> authors = authorService.getAuthors();
        for (Author author : authors) {
            List<Book> booksByAuthor = bookService.getBooksByAuthor(author);
            for (Book book : booksByAuthor) {
                System.out.println(book);
            }
        }
    }
}
