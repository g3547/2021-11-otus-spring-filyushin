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
        Genre genreById = genreRepository.findById(Long.parseLong(id)).orElseThrow();
        return genreById;
    }

    @Override
    public Genre getOrCreate(String name) {
        Genre genre = genreRepository.findByName(name).orElse(new Genre(0, name));
        genreRepository.save(genre);
        return genre;
    }

    @Override
    public long create(String name) {
        Genre genre = new Genre(0, name);
        return genreRepository.save(genre).getId();
    }

    @Override
    public void delete(long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        genreRepository.delete(genre);
    }
}
