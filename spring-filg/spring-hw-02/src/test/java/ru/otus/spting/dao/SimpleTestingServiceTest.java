package ru.otus.spting.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring.Main;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.AnswerReader;
import ru.otus.spring.service.SimpleTestingService;

public class SimpleTestingServiceTest {

    private static AnnotationConfigApplicationContext context;

    private static SimpleTestingService testingService;
    @Mock
    private AnswerReader answerReader;

    @BeforeAll
    public static void setUp() {
        context = new AnnotationConfigApplicationContext(Main.class);

        testingService = context.getBean(SimpleTestingService.class);

    }

    @Test
    public void testingServiceShouldCountCorrect() {
        Question q1 = new Question("1", "first question?", "a1");

        testingService.askQuestion(q1);

        Assertions.assertEquals("", testingService.getResult());
    }

}
