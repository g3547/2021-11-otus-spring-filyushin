package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@Entity
@Data
@Table(name = "COMMENT")
@AllArgsConstructor
public class Comment {

    @Id
    @Column(name = "COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMMENT")
    @SequenceGenerator(name = "SEQ_COMMENT", allocationSize = 1)
    private long id;

    @NotBlank
    @Column(name = "COMMENT", nullable = false)
    private String comment;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "BOOK_ID")
    private Book book;


}
