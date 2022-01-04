package ru.otus.spring.service;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getGenres();
    Genre getGenreById(long id);

    long create(String fullName);

    void delete(long id);
}
