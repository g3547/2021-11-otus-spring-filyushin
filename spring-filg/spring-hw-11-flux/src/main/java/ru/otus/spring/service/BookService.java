package ru.otus.spring.service;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

import java.util.List;

public interface BookService {
    void addBook(String title, String authorId, String genreId);

    void deleteBook(String bookId);

    void saveBook(Book book);

    Book getBookByTitle(String title);

    Book getBookById(String id);

    List<Comment> getBookComments(String id);

    long countBooks();

    List<Comment> getAllComments();

    boolean addBookComment(String bookId, String commentContent);

    void changeBookComment(String bookId, String commentContent);


    boolean deleteBookComment(String commentId);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getAllBooks();

}
