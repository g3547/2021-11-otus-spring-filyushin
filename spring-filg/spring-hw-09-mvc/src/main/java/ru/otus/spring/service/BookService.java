package ru.otus.spring.service;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

import java.util.List;

public interface BookService {
    void addBook(String title, long authorId, long genreId);

    void deleteBook(Long bookId);

    void saveBook(Book book);

    Book getBookById(long id);

    List<Comment> getBookComments(long id);

    long countBooks();

    List<Comment> getAllComments();

    boolean addBookComment(long bookId, String commentContent);

    void changeBookComment(long bookId, String commentContent);

    void changeBookForComment(long commentId, long newBookId);

    boolean deleteBookComment(long commentId);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getAllBooks();

}
