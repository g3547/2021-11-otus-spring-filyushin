package ru.otus.spring.repositories.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.repositories.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<Book> getBooks() {
        return em.createQuery("select b " +
                "from Book b " +
                "join fetch  b.author " +
                "join fetch b.genre", Book.class).getResultList();
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == 0) {
            em.persist(book);
            return book;
        }
        return em.merge(book);
    }

    @Override
    public void delete(Book book) {
        em.remove(book);
    }


    @Override
    // TODO: 02.01.2022 можно на джоин переписать
    public Optional<Book> getBookById(long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public long countBooks() {
        return   em.createQuery("select count(b) from Book b",Long.class).getSingleResult();
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        Query query = em.createQuery(
                "select  b from Book b " +
                        "where b.author = :author");
        query.setParameter("author", author);
        return query.getResultList();
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        Query query = em.createQuery(
                "select  b from Book b " +
                        "where b.genre = :genre");
        query.setParameter("genre", genre);
        return query.getResultList();
    }
}
