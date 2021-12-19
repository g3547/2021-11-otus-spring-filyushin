package ru.otus.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.service.GenreService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenreAuthorService implements GenreService {

    private final GenreDao dao;


    @Override
    public List<Genre> getGenres() {
        return dao.getGenres();
    }
}
