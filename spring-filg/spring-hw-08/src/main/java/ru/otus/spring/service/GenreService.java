package ru.otus.spring.service;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getGenres();

    Genre getGenreByName(String name);

    String create(String name);

    void delete(String name);
}
