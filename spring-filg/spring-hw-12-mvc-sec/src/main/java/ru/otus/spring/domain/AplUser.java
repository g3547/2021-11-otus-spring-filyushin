package ru.otus.spring.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AplUser {
    @Column(name = "USER_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USERS")
    @SequenceGenerator(name = "SEQ_USERS", allocationSize = 1)
    private long id;


    @NotNull
    @Column(name = "LOGIN")
    private String name;

    @NotNull
    @Column(name = "PASS")
    private String password;

}
