package ru.otus.spring.repositories;

import ru.otus.spring.domain.Book;

import java.util.Optional;

public interface BookRepositoryCustom {
    Optional<Book> findBookWith1inTitle();
}
