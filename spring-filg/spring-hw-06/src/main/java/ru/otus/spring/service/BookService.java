package ru.otus.spring.service;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

import java.util.List;

public interface BookService {
    public void addBook(String title, long authorId, long genreId);

    void deleteBook(Book book);

    void saveBook(Book book);

    Book getBookById(long id);

    long countBooks();

    List<Comment> getAllComments();

    boolean addBookComment(long bookId, String commentContent);

    boolean deleteBookComment(long commentId);

    List<Book> getBooksByAuthor(Author author);
    List<Book> getAllBooks();

}
