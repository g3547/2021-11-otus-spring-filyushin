package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Book;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.BookService;

@RequiredArgsConstructor
@ShellComponent
public class ShellApplicationEdit {
    private final BookService bookService;
    private final AuthorService authorService;


    @ShellMethod(value = "update book", key = {"editB"})
    @Transactional
    public void changeBookName(@ShellOption(defaultValue = "title1") String title,
                               @ShellOption(defaultValue = "prefix") String newName) {

        Book book = bookService.getBookByTitle(title);
        Book newBook = new Book(book.getId(), newName, book.getAuthor(), book.getGenre());
        bookService.saveBook(newBook);
        System.out.println("book was : " + book);
        System.out.println("book now : " + newBook);
    }

    @ShellMethod(value = "update author", key = {"editA"})
    @Transactional
    public void changeAuthorName(String oldName,
                                 @ShellOption(defaultValue = "prefix") String newName) {
        authorService.update(oldName, newName);
    }

    @ShellMethod(value = "update comment", key = {"editC"})
    @Transactional
    public void changeComment(@ShellOption(defaultValue = "title1") String bookTitle,
                              @ShellOption(defaultValue = "prefix") String newValue) {
        bookService.changeBookComment(bookTitle, newValue);
    }


}
