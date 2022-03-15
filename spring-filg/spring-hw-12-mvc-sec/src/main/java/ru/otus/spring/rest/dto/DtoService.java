package ru.otus.spring.rest.dto;

import ru.otus.spring.domain.Book;

import java.util.List;

public interface DtoService {

    BookDto bookToDto(Book book);

    Book bookDtoToBook(BookDto bookDto);

    List<BookDto> booksToDto(List<Book> book);
}
