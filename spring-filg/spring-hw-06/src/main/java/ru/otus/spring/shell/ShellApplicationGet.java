package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.repositories.BookRepository;
import ru.otus.spring.repositories.CommentRepository;
import ru.otus.spring.service.AuthorService;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellApplicationGet {
    private final AuthorService authorService;
    private final BookRepository bookService;
    private final CommentRepository commentRepository;

    @ShellMethod(value = "get book", key = {"getB"})
    public void getBookById(@ShellOption(defaultValue = "1") String id) {

        Book book = bookService.getBookById(Long.valueOf(id)).get();
        System.out.println(book);
    }

    @ShellMethod(value = "get book", key = {"getA"})
    public void getAuthorById(@ShellOption(defaultValue = "1") String id) {

        Author author = authorService.getById(Long.valueOf(id));
        System.out.println(author);
    }

    @ShellMethod(value = "get all books", key = {"getBs"})
    public void getBooks() {
        List<Book> books = bookService.getBooks();

        print(books);
    }

    @ShellMethod(value = "get all Authors", key = {"getAs"})
    public void getAuthors() {
        List<Author> authors = authorService.getAll();

        print(authors);
    }
//    @ShellMethod(value = "get all Comments", key = {"getCs"})
//    public void getComments() {
//        List<Comment> authors = commentRepository.getComments();
//
//        print(authors);
//    }

//    @ShellMethod(value = "get comment", key = {"getBC"})
//    public void getBookComments(@ShellOption(defaultValue = "1") String bookId) {
//
//        Book book = bookService.getBookById(Long.valueOf(bookId)).get();
//        List<Comment> booksComments = book.getComments();
//        print(booksComments);
//    }

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
