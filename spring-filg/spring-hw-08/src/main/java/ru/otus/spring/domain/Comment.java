package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Document(collection = "COMMENT")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private String id;

    @NotBlank
    private String comment;

    private String bookId;

    public Comment(String comment, String bookId) {
        this(null, comment, bookId);
    }
}
