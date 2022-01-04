package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.BookService;
import ru.otus.spring.service.GenreService;

import javax.transaction.Transactional;

@ShellComponent
@RequiredArgsConstructor
public class ShellApplicationAdd {
    private final AuthorService authorService;
    private final BookService bookService;
    private final GenreService genreService;


    @ShellMethod(value = "add book", key = {"addB"})
    @Transactional
    public void addBook(@ShellOption(defaultValue = "Title") String title,
                        @ShellOption(defaultValue = "1") long authorId,
                        @ShellOption(defaultValue = "1") long genreId) {

        bookService.addBook(title, authorId, genreId);
    }

    @ShellMethod(value = "add author", key = {"addA"})
    @Transactional
    public void addAuthor(@ShellOption String fullName) {

        authorService.create(fullName);
    }

    @ShellMethod(value = "add genre", key = {"addG"})
    @Transactional
    public void addGenre(@ShellOption String name) {

        genreService.create(name);
    }

    @ShellMethod(value = "add books comment", key = {"addBC"})
    @Transactional
    public void addBooksComment(@ShellOption(defaultValue = "1") long bookId,
                                @ShellOption(defaultValue = "good Book") String commentString) {
        bookService.addBookComment(bookId, commentString);
    }

}
