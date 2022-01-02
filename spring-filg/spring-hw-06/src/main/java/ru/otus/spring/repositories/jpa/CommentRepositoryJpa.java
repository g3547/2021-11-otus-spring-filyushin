package ru.otus.spring.repositories.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.repositories.CommentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryJpa implements CommentRepository {
    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<Comment> getBooksComments(Book book) {
        TypedQuery<Comment> query = em.createQuery(
                "select c from Comment c " +
                        "where c.book =:book", Comment.class);
        query.setParameter("book", book);
        return query.getResultList();
    }
    @Override
    public List<Comment> getComments() {
        return em.createQuery("select c from Comment c", Comment.class).getResultList();
    }

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == 0) {
            em.persist(comment);
            return comment;
        }
        return em.merge(comment);
    }

    @Override
    public void delete(Comment comment) {
        em.remove(comment);
    }

}
