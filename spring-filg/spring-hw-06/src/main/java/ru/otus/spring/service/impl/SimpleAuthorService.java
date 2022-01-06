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

    private final String NO_AUTHOR_FOUND = "no author found by id";

    @Override
    public long create(String fullName) {
        Author author = new Author(0, fullName);
        return authorRepository.save(author).getId();
    }

    @Override
    public void update(long id, String fullName) {
        Author author = authorRepository.getAuthorById(id).orElse(null);
        if (author != null) {
            author.setFullName(fullName);
            Author save = authorRepository.save(author);
            System.out.println("was updated to" + save.getFullName());
        } else throw new RuntimeException(NO_AUTHOR_FOUND);
    }

    @Override
    public Author getById(long id) {
        Author author = authorRepository.getAuthorById(id).orElse(null);
        if (author != null) {
            return author;
        } else throw new RuntimeException(NO_AUTHOR_FOUND);

    }

    @Override
    public List<Author> getAll() {
        return authorRepository.getAuthors();
    }

    @Override
    public void delete(long id) {
        Author author = authorRepository.getAuthorById(id).orElse(null);
        if (author != null) {
            authorRepository.delete(author);
        } else throw new RuntimeException(NO_AUTHOR_FOUND);
    }
}
