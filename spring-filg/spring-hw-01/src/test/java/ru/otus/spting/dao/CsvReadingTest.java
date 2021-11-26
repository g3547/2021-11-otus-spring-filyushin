package ru.otus.spting.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.dao.QuestionDaoFromCsv;
import ru.otus.spring.domain.Question;

public class CsvReadingTest {

    private static ClassPathXmlApplicationContext context;
    private static QuestionDaoFromCsv daoFromCsv;

    @BeforeAll
    public static void setUp() {
        context = new ClassPathXmlApplicationContext("spring-context.xml");

        daoFromCsv = context.getBean(QuestionDaoFromCsv.class);
    }

    @Test
    public void test() {
        Question etalon = new Question("1", "first question?", "kkk");
        Question question = daoFromCsv.getQuestionByNumber(1);
        Assertions.assertEquals(question, etalon);

    }

}
