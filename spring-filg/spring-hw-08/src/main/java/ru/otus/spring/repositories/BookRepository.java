package ru.otus.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long>, CustomBookRepository {
    Optional<Book> findBookById(String bookId);

    Optional<Book> findBookByTitle(String title);

    List<Book> findAll();

    List<Book> findBooksByAuthor(Author author);
}
