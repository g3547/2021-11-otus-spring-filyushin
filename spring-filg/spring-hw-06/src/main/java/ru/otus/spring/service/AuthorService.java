package ru.otus.spring.service;

import ru.otus.spring.domain.Author;

import java.util.List;

public interface AuthorService {

    long create(String name);

    void update(long id, String fullName);

    Author getById(long id);

    List<Author> getAll();

    void delete(long id);

}
