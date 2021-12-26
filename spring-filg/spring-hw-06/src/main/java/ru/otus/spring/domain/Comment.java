package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "AUTHOR")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Column(name = "COMMENT_ID")
    @Id
    private long id;

    @JoinColumn(name = "BOOK_ID")
    @OneToOne(targetEntity = Book.class, cascade = CascadeType.PERSIST)
    private Book book;

    @NotBlank
    @Column(name = "COMMENT",nullable = false)
    private String comment;

}
