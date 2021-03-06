package ru.otus.spring.repositories;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> getBookById(long bookId);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooks();

    Book save(Book newBook);

    long countBooks();

    void delete(Book book);

    void delete(long bookId);

    List<Book> getBooksByGenre(Genre genre);
}
