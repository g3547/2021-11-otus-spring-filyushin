package ru.otus.spring.repositories;

import ru.otus.spring.domain.Author;

import java.util.List;

public interface AuthorRepository {

    List<Author> getAuthors();

    Author getAuthorById(long id);
}
