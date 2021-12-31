package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.repositories.AuthorRepository;
import ru.otus.spring.repositories.BookRepository;
import ru.otus.spring.repositories.CommentRepository;
import ru.otus.spring.repositories.GenreRepository;

import javax.transaction.Transactional;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellApplication {
    private final AuthorRepository authorService;
    private final BookRepository bookService;
    private final GenreRepository genreService;
    private final CommentRepository commentRepository;

    @ShellMethod(value = "get book", key = {"getB"})
    public void getBookById(@ShellOption(defaultValue = "1") String id) {

        Book book = bookService.getBookById(Long.valueOf(id)).get();
        System.out.println(book);
    }
    @ShellMethod(value = "get all books", key = {"getBs"})
    public void getBooks() {
        List<Book> books = bookService.getBooks();

        print(books);
    }
    @ShellMethod(value = "get all Authors", key = {"getAs"})
    public void getAuthors() {
        List<Author> authors = authorService.getAuthors();

        print(authors);
    }

    @ShellMethod(value = "get comment", key = {"getBC"})
    public void getBookComments(@ShellOption(defaultValue = "1") String bookId) {

        Book book = bookService.getBookById(Long.valueOf(bookId)).get();
        List<Comment> booksComments = commentRepository.getBooksComments(book);
        print(booksComments);
    }

    @ShellMethod(value = "delete book", key = {"delB"})
    @Transactional
    public void deleteBookById(@ShellOption(defaultValue = "1") String bookId) {

        Book book = bookService.getBookById(Long.valueOf(bookId)).get();

        bookService.delete(book);
        System.out.println("deleted book: " + book);
    }
    @ShellMethod(value = "delete books comments", key = {"delBC"})
    @Transactional
    public void deleteBooksComments(@ShellOption(defaultValue = "1") String bookId) {

        Book book = bookService.getBookById(Long.valueOf(bookId)).get();
        List<Comment> booksComments = commentRepository.getBooksComments(book);
        for (Comment comment:booksComments) {
            commentRepository.delete(comment);
        }

        System.out.println("no comment book: " + book);
    }

    @ShellMethod(value = "delete book", key = {"editB"})
    public void changeBookName(@ShellOption(defaultValue = "1") String id,
                               @ShellOption(defaultValue = "prefix") String newName) {

        Book book = bookService.getBookById(Long.valueOf(id)).get();
        Book newBook = new Book(book.getId(), newName, book.getAuthor(), book.getGenre());
        bookService.update(newBook);
        System.out.println("book was : " + book);
        System.out.println("book now : " + newBook);
    }

    @ShellMethod(value = "add book", key = {"addB"})
    @Transactional
    public void addBook() {
        long id = bookService.countBooks() + 1;
        Book book = new Book(id, "Title" + id, authorService.getAuthors().get(0), genreService.getGenres().get(0));
        bookService.save(book);
    }
    @ShellMethod(value = "add books comment", key = {"addBC"})
    @Transactional
    public void addBooksComment(@ShellOption(defaultValue = "1") String bookId,
                                @ShellOption(defaultValue = "good Book") String commentString) {
        Comment comment= new Comment(Long.valueOf(bookId),commentString);
        commentRepository.save(comment);
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

    private void print(List objects) {
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
