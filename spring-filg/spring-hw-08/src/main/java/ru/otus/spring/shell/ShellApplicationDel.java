package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.BookService;


@RequiredArgsConstructor
@ShellComponent
public class ShellApplicationDel {
    private final BookService bookService;
    private final AuthorService authorService;


    @ShellMethod(value = "delete book", key = {"delB"})
    @Transactional
    public void deleteBookById(@ShellOption(defaultValue = "title1") String bookId) {

        bookService.deleteBook(bookId);
        System.out.println("deleted book: " + bookId);
    }

    @ShellMethod(value = "delete author", key = {"delA"})
    @Transactional
    public void deleteAuthorById(
            @ShellOption(defaultValue = "Ivanov Petr Olegovich") String fullName) {

        authorService.delete(fullName);

        System.out.println("deleted author: " + fullName);
    }

    @ShellMethod(value = "delete books comments", key = {"delBC"})
    @Transactional
    public void deleteBooksComments(@ShellOption String commentId) {

        bookService.deleteBookComment(commentId);
    }

}
