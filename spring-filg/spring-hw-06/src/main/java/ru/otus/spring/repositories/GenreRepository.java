package ru.otus.spring.repositories;

import ru.otus.spring.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    List<Genre> getGenres();

    Optional<Genre> getGenreById(long id);

}
