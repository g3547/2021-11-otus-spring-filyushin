package ru.otus.spring.repositories;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring.domain.Author;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"ru.otus.spring.repositories"})
@DisplayName("AuthorRepository должен ")
public class AuthorRepoTest {
    @Autowired
    private AuthorRepository authorRepository;

    private static final Author TEST_AUTHOR = new Author("tester test");


    @DisplayName(" возвращать корректное кол-во авторов")
    @Test
    void shouldReturnCorrectAuthorList() {
        val authors = authorRepository.findAll();
        val author = authors.get(0);
        assertThat(authors).isNotNull().hasSize(2);
    }

    @DisplayName(" сохранять авторов")
    @Test
    void shouldSaveAuthors() {
        val authors = authorRepository.findAll();

        authorRepository.save(TEST_AUTHOR);

        val authorsAfter = authorRepository.findAll();

        assertThat(authorsAfter).isNotNull().hasSize(authors.size() + 1);

        val author = authorRepository.findAuthorByFullName(TEST_AUTHOR.getFullName()).get();

        assertThat(author).isEqualTo(TEST_AUTHOR);


    }

}
