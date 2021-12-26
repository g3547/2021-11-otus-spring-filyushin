package ru.otus.spring.service;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void deleteBook(Book book);

    void editBook(Book book);

    Book getBookById(long id);

    int countBooks();

    List<Book> getBooksByAuthor(Author author);

}
