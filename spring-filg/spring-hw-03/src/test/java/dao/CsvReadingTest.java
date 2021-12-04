package dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring.dao.QuestionDaoFromCsv;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.QuestionServiceImpl;

@SpringBootTest
public class CsvReadingTest {

    private static AnnotationConfigApplicationContext context;
    private static QuestionDaoFromCsv daoFromCsv;
    private static QuestionServiceImpl daoService;


    @Test
    public void csvReaderShouldCreateQuestion() {
        Question etalon = new Question("1", "first question?", "a1");
        Question question = daoFromCsv.getQuestionByNumber(1);
        Assertions.assertEquals(question, etalon);
    }

    @Test
    public void daoServiceShouldReturnSize() {
        Assertions.assertEquals(5, daoService.getQuestionListSize());
    }

}
