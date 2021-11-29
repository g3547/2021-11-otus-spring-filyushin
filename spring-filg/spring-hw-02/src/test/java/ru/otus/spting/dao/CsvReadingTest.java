package ru.otus.spting.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring.Main;
import ru.otus.spring.dao.QuestionDaoFromCsv;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.QuestionServiceImpl;

public class CsvReadingTest {

    private static AnnotationConfigApplicationContext context;
    private static QuestionDaoFromCsv daoFromCsv;
    private static QuestionServiceImpl daoService;


    @BeforeAll
    public static void setUp() {
        context = new AnnotationConfigApplicationContext(Main.class);

        daoFromCsv = context.getBean(QuestionDaoFromCsv.class);
        daoService = context.getBean(QuestionServiceImpl.class);

    }

    @Test
    public void csvReaderShouldCreateQuestion() {
        Question etalon = new Question("1", "first question?", "a1");
        Question question = daoFromCsv.getQuestionByNumber(1);
        Assertions.assertEquals(question, etalon);
    }

    @Test
    public void daoServiceShouldReturnSize() {
        Assertions.assertEquals(4, daoService.getQuestionListSize());
    }

}
