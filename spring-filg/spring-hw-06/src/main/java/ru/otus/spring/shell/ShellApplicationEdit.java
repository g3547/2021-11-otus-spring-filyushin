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

//    private final CommentRepository commentRepository;


    @ShellMethod(value = "update book", key = {"editB"})
    @Transactional
    public void changeBookName(@ShellOption(defaultValue = "1") String id,
                               @ShellOption(defaultValue = "prefix") String newName) {

        Book book = bookService.getBookById(Long.valueOf(id));
        Book newBook = new Book(book.getId(), newName, book.getAuthor(), book.getGenre());
        bookService.saveBook(newBook);
        System.out.println("book was : " + book);
        System.out.println("book now : " + newBook);
    }

    @ShellMethod(value = "update author", key = {"editA"})
    @Transactional
    public void changeAuthorName(@ShellOption(defaultValue = "1") long id,
                                 @ShellOption(defaultValue = "prefix") String newName) {
        authorService.update(id,newName);
    }

//    @ShellMethod(value = "update comment", key = {"editC"})
//    @Transactional
//    public void changeComment(@ShellOption(defaultValue = "1") String bookId,
//                              @ShellOption(defaultValue = "prefix") String newValue) {
//
//        Comment comment =
//                bookService.getBookById(Long.parseLong(bookId)).get().getComments().get(0);
//        Comment newComment = new Comment(comment.getId(), newValue, comment.getBook());
//        commentRepository.save(newComment);
//        System.out.println("comment was : " + comment);
//        System.out.println("comment now : " + comment);
//    }


}
