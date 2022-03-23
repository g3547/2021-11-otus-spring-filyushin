package ru.otus.spring.repositories;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.domain.Comment;

import java.util.List;

@RequiredArgsConstructor
public class CustomBookRepositoryImpl implements CustomBookRepository {

    private final CommentRepository commentRepository;

    @Override
    public void removeAllBooksComments(String bookId) {
        List<Comment> comments = commentRepository.findAllByBookId(bookId);
        for (Comment comment : comments) {
            commentRepository.delete(comment);
        }
    }
}
