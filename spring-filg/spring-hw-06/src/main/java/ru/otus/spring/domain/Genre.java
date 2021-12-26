package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "GENRE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genre {
    @Column(name = "GENRE_ID")
    @Id
    private  long id;


    @NotNull
    @Column(name = "NAME")
    private  String name;
}
