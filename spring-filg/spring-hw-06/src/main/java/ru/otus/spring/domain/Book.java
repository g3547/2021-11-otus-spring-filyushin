package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BOOK")
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
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 5)
    private  Author author;

    @OneToOne(targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "GENRE_ID")
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 5)
    private  Genre genre;

    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID")
    private List<Comment> comments;

    public Book(long id, String title, Author author, Genre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
}
