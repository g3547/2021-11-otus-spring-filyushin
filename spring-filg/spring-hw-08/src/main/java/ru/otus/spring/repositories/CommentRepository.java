package ru.otus.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

import java.util.Optional;

public interface CommentRepository extends MongoRepository<Comment, Long> {

    Optional<Comment> findById(long commentId);

    @Transactional
    @Query("update Comment c set c.book = :book where c.id = :id")
    void updateCommentsBookId(@Param("id") long commentId, @Param("book") Book newBook);
}
