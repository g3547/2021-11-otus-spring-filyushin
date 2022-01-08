package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.BookService;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellApplicationGet {
    private final AuthorService authorService;
    private final BookService bookService;

    @ShellMethod(value = "get book", key = {"getB"})
    public void getBookById(@ShellOption(defaultValue = "1") long id) {

        Book book = bookService.getBookById(id);
        System.out.println(book);
    }

    @ShellMethod(value = "get book", key = {"getA"})
    public void getAuthorById(@ShellOption(defaultValue = "1") long id) {

        Author author = authorService.getById(id);
        System.out.println(author);
    }

    @ShellMethod(value = "get all books", key = {"getBs"})
    public void getBooks() {
        List<Book> books = bookService.getAllBooks();
        print(books);
    }

    @ShellMethod(value = "get all Authors", key = {"getAs"})
    public void getAuthors() {
        List<Author> authors = authorService.getAll();

        print(authors);
    }

    @ShellMethod(value = "get all Comments", key = {"getCs"})
    public void getComments() {
        List<Comment> authors = bookService.getAllComments();

        print(authors);
    }

    @ShellMethod(value = "get book comment", key = {"getBC"})
    @Transactional(readOnly = true)
    public void getBookComments(@ShellOption(defaultValue = "1") long bookId) {
        List<Comment> booksComments = bookService.getBookComments(bookId);
        print(booksComments);
    }

    @ShellMethod(value = "print author's books", key = {"getAB"})
    public void getAuthorsBooks() {
        List<Author> authors = authorService.getAll();
        for (Author author : authors) {
            List<Book> booksByAuthor = bookService.getBooksByAuthor(author);
            print(booksByAuthor);
        }
    }

    private void print(List objects) {
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
