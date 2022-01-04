package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Book;
import ru.otus.spring.repositories.CommentRepository;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.BookService;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@ShellComponent
public class ShellApplicationDel {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CommentRepository commentRepository;


    @ShellMethod(value = "delete book", key = {"delB"})
    @Transactional
    public void deleteBookById(@ShellOption(defaultValue = "1") long bookId) {

        Book book = bookService.getBookById(bookId);

        bookService.deleteBook(book);
        System.out.println("deleted book: " + book);
    }
    @ShellMethod(value = "delete author", key = {"delA"})
    @Transactional
    public void deleteAuthorById(@ShellOption(defaultValue = "1") String authorId) {

        authorService.delete(Long.parseLong(authorId));

        System.out.println("deleted author: " + authorId);
    }

//    @ShellMethod(value = "delete books comments", key = {"delBC"})
//    @Transactional
//    public void deleteBooksComments(@ShellOption(defaultValue = "1") String bookId) {
//
//        Book book = bookService.getBookById(Long.valueOf(bookId)).get();
//        List<Comment> booksComments = book.getComments();
//        for (Comment comment : booksComments) {
//            commentRepository.delete(comment);
//        }
//
//        System.out.println("no comment book: " + book);
//    }

}
