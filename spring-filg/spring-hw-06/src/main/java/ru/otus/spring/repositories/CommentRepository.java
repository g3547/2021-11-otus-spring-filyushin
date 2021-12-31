package ru.otus.spring.repositories;

import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

import java.util.List;

public interface CommentRepository {

    List<Comment> getBooksComments(Book book);

    Comment save(Comment comment);

    void delete(Comment comment);

    void change(Comment comment);
}
