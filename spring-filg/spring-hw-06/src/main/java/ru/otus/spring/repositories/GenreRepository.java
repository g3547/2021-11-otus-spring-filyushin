package ru.otus.spring.repositories;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreRepository {

    List<Genre> getGenres();

    Genre getGenreById(long id);

}
