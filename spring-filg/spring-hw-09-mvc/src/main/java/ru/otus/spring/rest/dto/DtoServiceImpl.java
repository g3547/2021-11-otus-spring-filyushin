package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;
import ru.otus.spring.service.AuthorService;
import ru.otus.spring.service.GenreService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DtoServiceImpl implements DtoService {

    private final GenreService genreService;
    private final AuthorService authorService;

    @Override
    public BookDto bookToDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor().getFullName(),
                book.getGenre().getName()
        );
    }

    @Override
    public Book bookDtoToBook(BookDto bookDto) {
        Author author = authorService.getOrCreate(bookDto.getAuthor());
        Genre genre = genreService.getOrCreate(bookDto.getGenre());

        return new Book(bookDto.getId(), bookDto.getTitle(), author, genre);
    }

    @Override
    public List<BookDto> booksToDto(List<Book> books) {
        val list = new ArrayList<BookDto>();
        for (Book book : books) {
            list.add(bookToDto(book));
        }
        return list;
    }
}
