package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "AUTHOR")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {
    @Id
    private long id;


    private String fullName;

}
