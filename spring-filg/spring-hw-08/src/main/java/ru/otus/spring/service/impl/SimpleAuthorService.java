package ru.otus.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Author;
import ru.otus.spring.repositories.AuthorRepository;
import ru.otus.spring.service.AuthorService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SimpleAuthorService implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public String create(String fullName) {
        Author author = new Author(fullName);
        return authorRepository.save(author).getId();
    }

    @Override
    public void update(String id, String fullName) {
        Author author = authorRepository.findAuthorById(id).orElseThrow();
        author.setFullName(fullName);
        Author save = authorRepository.save(author);
        System.out.println("was updated to" + save.getFullName());
    }

    @Override
    public Author getById(String id) {
        Author author = authorRepository.findAuthorById(id).orElseThrow();
        return author;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void delete(String id) {
        Author author = authorRepository.findAuthorById(id).orElseThrow();
        authorRepository.delete(author);
    }
}
