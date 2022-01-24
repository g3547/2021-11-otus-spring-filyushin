package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.BookService;
import ru.otus.spring.service.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class ShellApplicationAdd {
    private final AuthorService authorService;
    private final BookService bookService;
    private final GenreService genreService;


    @ShellMethod(value = "add book", key = {"addB"})
    public void addBook(@ShellOption(defaultValue = "Title") String title,
                        @ShellOption(defaultValue = "1") String authorId,
                        @ShellOption(defaultValue = "1") String genreId) {

        bookService.addBook(title, authorId, genreId);
    }

    @ShellMethod(value = "add author", key = {"addA"})
    public void addAuthor(@ShellOption String fullName) {
        authorService.create(fullName);
    }

    @ShellMethod(value = "add genre", key = {"addG"})
    public void addGenre(@ShellOption String name) {

        genreService.create(name);
    }

    @ShellMethod(value = "add books comment", key = {"addBC"})
    @Transactional
    public void addBooksComment(@ShellOption(defaultValue = "title1") String title,
                                @ShellOption(defaultValue = "good Book") String commentString) {
        bookService.addBookComment(title, commentString);
    }

}
