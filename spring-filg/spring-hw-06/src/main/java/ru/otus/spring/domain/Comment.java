package ru.otus.spring.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(name = "COMMENT", nullable = false)
    private String comment;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "BOOK_ID")
    private Book book;


}
