package ru.otus.spring.rest.dto;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.List;

public interface DtoService {

    BookDto bookToDto(Book book);

    Book bookDtoToBook(BookDto bookDto);

    List<BookDto> booksToDto(List<Book> book);

    List<AuthorDto> authorsToDto(List<Author> authors);

    List<GenreDto> genresToDto(List<Genre> genres);
}
