package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.repositories.BookRepository;
import ru.otus.spring.repositories.CommentRepository;

@RequiredArgsConstructor
@ShellComponent
public class ShellApplicationEdit {
    private final BookRepository bookService;
    private final CommentRepository commentRepository;


    @ShellMethod(value = "update book", key = {"editB"})
    public void changeBookName(@ShellOption(defaultValue = "1") String id,
                               @ShellOption(defaultValue = "prefix") String newName) {

        Book book = bookService.getBookById(Long.valueOf(id)).get();
        Book newBook = new Book(book.getId(), newName, book.getAuthor(), book.getGenre());
        bookService.save(newBook);
        System.out.println("book was : " + book);
        System.out.println("book now : " + newBook);
    }

    @ShellMethod(value = "update comment", key = {"editC"})
    public void changeComment(@ShellOption(defaultValue = "1") String bookId,
                              @ShellOption(defaultValue = "prefix") String newValue) {

        Comment comment = commentRepository.getBooksComments(
                bookService.getBookById(
                        Long.parseLong(bookId)).get()).get(0);
        Comment newComment = new Comment(comment.getId(), comment.getBook(), newValue);
        commentRepository.save(newComment);
        System.out.println("comment was : " + comment);
        System.out.println("comment now : " + comment);
    }


}
