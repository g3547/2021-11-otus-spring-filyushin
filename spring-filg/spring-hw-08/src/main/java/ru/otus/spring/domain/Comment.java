package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@Data
@Document(collection = "COMMENT")
@AllArgsConstructor
public class Comment {

    @Id
    private long id;

    @NotBlank
    private String comment;

    private Book book;


}
