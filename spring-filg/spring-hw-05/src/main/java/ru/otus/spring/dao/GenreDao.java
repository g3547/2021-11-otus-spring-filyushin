package ru.otus.spring.dao;

import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getGenres();

    Genre getGenreById(long id);

}
