package ru.otus.spring.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "GENRE")
@Data
public class Genre {
    @Id
    private String id;

    @NotNull
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
