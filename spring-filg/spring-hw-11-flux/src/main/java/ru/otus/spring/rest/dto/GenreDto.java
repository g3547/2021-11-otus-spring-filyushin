package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.otus.spring.domain.Genre;

@Getter
@Setter
@AllArgsConstructor
public class GenreDto {
    private String id;
    private String name;

    public static GenreDto toDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }
}
