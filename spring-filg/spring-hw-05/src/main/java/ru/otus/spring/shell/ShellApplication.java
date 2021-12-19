package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.domain.Author;
import ru.otus.spring.service.AuthorService;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellApplication {
    private final AuthorService authorService;

    @ShellMethod(value = "get authors", key = {"getA"})
    public void printAuthors() {
        List<Author> authors = authorService.getAuthors();
        for (Author author : authors) {
            System.out.println(author);
        }
    }
}
