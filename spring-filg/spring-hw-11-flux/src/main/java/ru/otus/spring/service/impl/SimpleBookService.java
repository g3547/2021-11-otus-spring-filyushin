package ru.otus.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.repositories.AuthorRepository;
import ru.otus.spring.repositories.BookRepository;
import ru.otus.spring.repositories.CommentRepository;
import ru.otus.spring.repositories.GenreRepository;
import ru.otus.spring.service.BookService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SimpleBookService implements BookService {
    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    static final String NULL_BOOK = "Didn't find book";

    @Override
    @Transactional
    public void addBook(String title, String authorId, String genreId) {
        Book book = new Book(title,
                authorRepository.findAuthorById(authorId).get(),
                genreRepository.findByName(genreId).get());

        bookRepository.save(book);

    }

    @Override
    public void deleteBook(String title) {
        Book book = bookRepository.findBookByTitle(title).orElseThrow();
        bookRepository.delete(book);
    }

    @Override
    public void saveBook(Book book) {
        if (book != null) {
            bookRepository.save(book);
        } else {
            throw new RuntimeException(NULL_BOOK);
        }
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findBookByTitle(title).orElseThrow();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findBookById(id).orElseThrow();
    }

    @Override
    public List<Comment> getBookComments(String title) {
        Book book = bookRepository.findBookByTitle(title).orElseThrow();

        return commentRepository.findAllByBookId(book.getId());
    }

    @Override
    public long countBooks() {
        return bookRepository.count();
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public boolean addBookComment(String title, String content) {
        Book book = bookRepository.findBookByTitle(title).orElseThrow();

        Comment comment = new Comment(content, book.getId());
        Comment save = commentRepository.save(comment);

        System.out.println("Saved with id " + save.getId());
        return true;
    }

    @Override
    public void changeBookComment(String title, String commentContent) {

        Book book = bookRepository.findBookById(title).orElseThrow();
        Comment comment =
                book.getComments().get(0);
        Comment newComment = new Comment(comment.getId(), commentContent, comment.getBookId());
        commentRepository.save(newComment);
        System.out.println("comment was : " + comment);
        System.out.println("comment now : " + comment);
    }


    @Override
    public boolean deleteBookComment(String commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        commentRepository.delete(comment);
        System.out.println("success delete comment " + commentId);
        return true;
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookRepository.findBooksByAuthor(author);
    }

    @Override
    public List<Book> getAllBooks() {
        System.out.println("start searching for books");
        return bookRepository.findAll();
    }
}
