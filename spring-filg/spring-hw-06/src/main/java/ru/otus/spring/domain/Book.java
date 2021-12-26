package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Column(name = "BOOK_ID")
    @Id
    private  long id;

    @Column(name = "TITLE")
    private  String title;

    @OneToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    private  Author author;

    @OneToOne(targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "GENRE_ID")
    private  Genre genre;
}
