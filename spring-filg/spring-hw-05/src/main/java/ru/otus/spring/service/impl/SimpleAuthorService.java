package ru.otus.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.service.AuthorService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SimpleAuthorService implements AuthorService {

    private final AuthorDao dao;

    @Override
    public List<Author> getAuthors() {
        return dao.getAuthors();
    }
}
