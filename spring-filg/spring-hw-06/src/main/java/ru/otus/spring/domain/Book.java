package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@RequiredArgsConstructor
@Entity
@Data
@Table(name = "BOOK")
@AllArgsConstructor
public class Book {
    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOOK")
    @SequenceGenerator(name = "SEQ_BOOK",allocationSize = 1)
    private long id;

    @Column(name = "TITLE")
    private String title;

    @OneToOne(targetEntity = Author.class)
    @JoinColumn(name = "AUTHOR_ID")
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 5)
    private Author author;

    @OneToOne(targetEntity = Genre.class)
    @JoinColumn(name = "GENRE_ID")
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 5)
    private Genre genre;

//    @OneToMany(targetEntity = Comment.class,orphanRemoval = true )
//    @ToString.Exclude
//    private List<Comment> comments;

//    public Book(long id, String title, Author author, Genre genre) {
//        this(id,title,author,genre,null);
//    }
}
