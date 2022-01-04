package ru.otus.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
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
    public void addBook(String title, long authorId, long genreId) {
        Book book = new Book(0, title,
                authorRepository.getAuthorById(authorId).get(),
                genreRepository.getGenreById(genreId).get());

        if (book != null) {
            bookRepository.save(book);
        } else {
            throw new RuntimeException(NULL_BOOK);
        }
    }

    @Override
    public void deleteBook(Book book) {
        if (book != null) {
            bookRepository.delete(book);
        } else {
            throw new RuntimeException(NULL_BOOK);
        }
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
        Book book = bookRepository.getBookById(id).orElse(null);
        if (book == null) throw new RuntimeException(NULL_BOOK);
        return book;
    }

    @Override
    public long countBooks() {
        return bookRepository.countBooks();
    }

//    @Override
//    public boolean addBookComment(long id, String content) {
//        Book book = bookRepository.getBookById(Long.valueOf(id)).get();
//        Comment comment = new Comment(commentRepository.countComments() + 1, content, book);
//        Comment save = commentRepository.save(comment);
//        System.out.println("Saved with id " + save.getId());
//        return true;
//    }

//    @Override
//    public boolean deleteBookComment(long commentId) {
//        Comment comment = commentRepository.getById(commentId).orElse(null);
//        if (comment != null) {
//            commentRepository.delete(comment);
//            return true;
//        }
//        return false;
//    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookRepository.getBooksByAuthor(author);
    }
}
