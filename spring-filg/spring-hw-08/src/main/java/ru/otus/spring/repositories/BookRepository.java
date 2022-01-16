package ru.otus.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, Long> {
    Optional<Book> findBookById(long bookId);

    List<Book> findBooksByAuthor(Author author);
}
