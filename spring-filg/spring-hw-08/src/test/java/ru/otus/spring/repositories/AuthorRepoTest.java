package ru.otus.spring.repositories;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"ru.otus.spring.repositories"})
@DisplayName("AuthorRepository должен ")
public class AuthorRepoTest {
    @Autowired
    private AuthorRepository authorRepository;

    @DisplayName(" возвращать корректный список авторов")
    @Test
    void shouldReturnCorrectKnowledgeList() {
        val authors = authorRepository.findAll();
        val author = authors.get(0);
        val experience = teacher.getExperience();
        assertThat(experience).isNotNull().hasSize(3);

        val actualExperience = teacherRepository.getTeacherExperienceById(teacher.getId());
        assertThat(actualExperience).containsExactlyInAnyOrder(experience.toArray(new Knowledge[0]));

    }

}
