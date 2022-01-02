package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "COMMENT")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    public Comment(Book book, String comment) {
        this.book = book;
        this.comment = comment;
    }

    @Column(name = "COMMENT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @NotBlank
    @Column(name = "COMMENT",nullable = false)
    private String comment;

}
