package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "GENRE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genre {
    @Id
    private long id;

    @NotNull
    private String name;
}
