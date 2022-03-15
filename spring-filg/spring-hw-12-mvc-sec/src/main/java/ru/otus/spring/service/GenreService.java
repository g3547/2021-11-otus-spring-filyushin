package ru.otus.spring.service;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getGenres();

    Genre getGenreById(String id);

    Genre getOrCreate(String name);


    long create(String name);

    void delete(long id);
}
