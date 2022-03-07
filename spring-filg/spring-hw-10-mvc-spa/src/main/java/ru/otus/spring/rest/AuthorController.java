package ru.otus.spring.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.rest.dto.AuthorDto;
import ru.otus.spring.rest.dto.DtoService;
import ru.otus.spring.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final DtoService dtoService;
    private final AuthorService authorService;

    @GetMapping("api/author")
    public List<AuthorDto> getAllAuthors() {
        return dtoService.authorsToDto(authorService.getAll());
    }

}
