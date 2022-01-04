package ru.otus.spring.repositories;

import ru.otus.spring.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    List<Comment> getComments();

    Comment save(Comment comment);

    Optional<Comment> getById(long commentId);

    public long countComments();

    void delete(Comment comment);
}
