package ru.otus.spring.repositories;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;

public interface BookRepository {
    Book getBookById(long id);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByGenre(Genre genre);

    List<Book> getBooks();

    void addBook(Book newBook);

    int countBooks();

    void updateBook(Book book);

    void deleteBook(Book book);

}
