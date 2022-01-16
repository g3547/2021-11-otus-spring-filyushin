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
    public void addBook(String title, long authorId, long genreId) {
        Book book = new Book(0, title,
                authorRepository.findAuthorById(authorId).get(),
                genreRepository.findById(genreId).get());

        bookRepository.save(book);

    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findBookById(bookId).orElseThrow();
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
    public Book getBookById(long id) {
        Book book = bookRepository.findBookById(id).orElseThrow();
        return book;
    }


    @Override
    public List<Comment> getBookComments(long id) {
        Book book = bookRepository.findBookById(id).orElseThrow();
        return book.getComments();
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
    public boolean addBookComment(long id, String content) {
        Book book = bookRepository.findBookById(id).orElseThrow();

        Comment comment = new Comment(0, content, book);
        Comment save = commentRepository.save(comment);

        System.out.println("Saved with id " + save.getId());
        return true;
    }

    @Override
    public void changeBookComment(long bookId, String commentContent) {

        Book book = bookRepository.findBookById(bookId).orElseThrow();
        Comment comment =
                book.getComments().get(0);
        Comment newComment = new Comment(comment.getId(), commentContent, comment.getBook());
        commentRepository.save(newComment);
        System.out.println("comment was : " + comment);
        System.out.println("comment now : " + comment);
    }

    @Override
    public void changeBookForComment(long commentId, long newBookId) {
        Book newBook = bookRepository.findBookById(newBookId).orElseThrow();

        Comment comment = commentRepository.findById(commentId).orElseThrow();
        commentRepository.updateCommentsBookId(commentId, newBook);
    }

    @Override
    public boolean deleteBookComment(long commentId) {
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
