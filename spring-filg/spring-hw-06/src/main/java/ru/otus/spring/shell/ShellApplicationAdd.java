package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Author;
import ru.otus.spring.repositories.AuthorRepository;
import ru.otus.spring.repositories.CommentRepository;
import ru.otus.spring.repositories.GenreRepository;
import ru.otus.spring.service.BookService;

import javax.transaction.Transactional;

@ShellComponent
@RequiredArgsConstructor
public class ShellApplicationAdd {
    private final AuthorRepository authorService;
    private final BookService bookService;
    private final GenreRepository genreService;
    private final CommentRepository commentRepository;


    @ShellMethod(value = "add book", key = {"addB"})
    @Transactional
    public void addBook(@ShellOption(defaultValue = "Title") String title,
                        @ShellOption(defaultValue = "1") String authorId,
                        @ShellOption(defaultValue = "1") String genreId) {

        bookService.addBook(title,Long.valueOf(authorId),Long.valueOf(genreId));
    }
    @ShellMethod(value = "add author", key = {"addA"})
    @Transactional
    public void addAuthor(@ShellOption String fullName) {

        authorService.save(new Author(0,fullName));
    }

//    @ShellMethod(value = "add books comment", key = {"addBC"})
//    @Transactional
//    public void addBooksComment(@ShellOption(defaultValue = "1") String bookId,
//                                @ShellOption(defaultValue = "good Book") String commentString) {
//        Book book = bookService.getBookById(Long.valueOf(bookId));
//        Comment comment = new Comment(commentRepository.countComments()+1,commentString,book);
//        Comment save = commentRepository.save(comment);
//        System.out.println("Saved with id "+save.getId() );
//    }

}
