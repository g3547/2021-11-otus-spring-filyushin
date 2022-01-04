package ru.otus.spring.repositories.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repositories.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GenreRepositoryJpa implements GenreRepository {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<Genre> getGenres() {
        return em.createQuery("select g from Genre g", Genre.class).getResultList();

    }

    @Override
    public Optional<Genre> getGenreById(long id) {
        return Optional.ofNullable(em.find(Genre.class, id));

    }
}
