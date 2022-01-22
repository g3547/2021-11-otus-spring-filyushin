package ru.otus.spring.service;

import ru.otus.spring.domain.Author;

import java.util.List;

public interface AuthorService {

    String create(String name);

    void update(String id, String fullName);

    Author getById(String id);

    List<Author> getAll();

    void delete(String id);

}
