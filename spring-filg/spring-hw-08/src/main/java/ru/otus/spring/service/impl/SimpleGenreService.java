package ru.otus.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repositories.GenreRepository;
import ru.otus.spring.service.GenreService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SimpleGenreService implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(String id) {
        return genreRepository.findById(id).orElseThrow();
    }

    @Override
    public String create(String name) {
        return genreRepository.save(new Genre(name)).getId();
    }

    @Override
    public void delete(long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        genreRepository.delete(genre);
    }
}
