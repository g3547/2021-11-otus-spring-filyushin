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
    public long create(String fullName) {
        Author author = new Author(0, fullName);
        return authorRepository.save(author).getId();
    }

    @Override
    public Author getOrCreate(String name) {
        Author author = authorRepository.findByFullName(name).orElse(new Author(0, name));
        authorRepository.save(author);
        return author;
    }

    @Override
    public void update(long id, String fullName) {
        Author author = authorRepository.findAuthorById(id).orElseThrow();
        author.setFullName(fullName);
        Author save = authorRepository.save(author);
        System.out.println("was updated to" + save.getFullName());
    }

    @Override
    public Author getById(long id) {
        Author author = authorRepository.findAuthorById(id).orElseThrow();
        return author;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void delete(long id) {
        Author author = authorRepository.findAuthorById(id).orElseThrow();
        authorRepository.delete(author);
    }
}
