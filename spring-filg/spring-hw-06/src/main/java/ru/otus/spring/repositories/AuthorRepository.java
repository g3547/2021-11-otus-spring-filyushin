package ru.otus.spring.repositories;

import ru.otus.spring.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    List<Author> getAuthors();

    Optional<Author> getAuthorById(long id);
}
