package ru.otus.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAll();

    Optional<Comment> findById(long commentId);


    @Modifying
    @Transactional
    @Query("update Comment c set c.book = :book where c.id = :id")
    void updateCommentsBookId(@Param("id") long commentId, @Param("book") Book newBook);
}
