package ru.otus.spring.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.rest.dto.DtoService;
import ru.otus.spring.rest.dto.GenreDto;
import ru.otus.spring.service.GenreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenreController {

    private final DtoService dtoService;
    private final GenreService genreService;

    @GetMapping("api/genre")
    public Mono<List<GenreDto>> getAllAuthors() {
        return Flux.fromIterable(dtoService.genresToDto(genreService.getGenres()))
                .collectList();
    }

}
