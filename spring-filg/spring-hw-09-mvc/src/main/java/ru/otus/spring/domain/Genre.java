package ru.otus.spring.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "GENRE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genre {
    @Column(name = "GENRE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMMENT")
    @SequenceGenerator(name = "SEQ_GENRE", allocationSize = 1)
    private long id;


    @NotNull
    @Column(name = "NAME")
    private String name;
}
