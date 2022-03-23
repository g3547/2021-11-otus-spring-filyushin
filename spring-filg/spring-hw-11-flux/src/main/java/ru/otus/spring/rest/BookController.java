package ru.otus.spring.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.domain.Book;
import ru.otus.spring.rest.dto.BookDto;
import ru.otus.spring.rest.dto.DtoService;
import ru.otus.spring.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final DtoService dtoService;

    @GetMapping("/api/book")
    public Mono<List<BookDto>> getAllBooks() {
        return Flux.fromIterable(dtoService.booksToDto(bookService.getAllBooks())).collectList();
    }


    @GetMapping("/api/book/{id}")
    public Mono<BookDto> getBook(@PathVariable("id") String id) {
        return Mono.just(dtoService.bookToDto(bookService.getBookById(id)));
    }

    @PostMapping("/api/book/{id}")
    public Mono<BookDto> editBook(@PathVariable("id") String id, @RequestBody BookDto bookDto) {

        Book book = dtoService.bookDtoToBook(bookDto);
        bookService.saveBook(book);
        return Mono.just(dtoService.bookToDto(bookService.getBookById(id)));
    }

    @PostMapping("/api/book")
    public void addBook(@RequestBody BookDto bookDto) {
        Book book = dtoService.bookDtoToBook(bookDto);
        bookService.saveBook(book);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteBook(@PathVariable("id") String id) {
        bookService.deleteBook(id);
    }

}
