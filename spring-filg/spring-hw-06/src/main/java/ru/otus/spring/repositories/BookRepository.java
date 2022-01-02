package ru.otus.spring.repositories;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> getBookById(long bookId);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByGenre(Genre genre);

    List<Book> getBooks();

    Book save(Book newBook);

    long countBooks();

    void delete(Book book);

}
