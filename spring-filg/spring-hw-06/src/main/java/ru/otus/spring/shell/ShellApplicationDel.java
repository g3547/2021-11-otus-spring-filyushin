package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.repositories.BookRepository;
import ru.otus.spring.repositories.CommentRepository;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@ShellComponent
public class ShellApplicationDel {
    private final BookRepository bookService;
    private final CommentRepository commentRepository;



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
        for (Comment comment : booksComments) {
            commentRepository.delete(comment);
        }

        System.out.println("no comment book: " + book);
    }

}
