package ru.otus.spring.dao;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;

public interface BookDao {
    Book getBookById(long id);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByGenre(Genre genre);

    List<Book> getBooks();

    void addBook(Book newBook);

    void updateBook(Book book);

    void deleteBook(Book book);

}
