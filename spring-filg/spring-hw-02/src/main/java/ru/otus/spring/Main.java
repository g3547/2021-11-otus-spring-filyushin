package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.service.QuestionServiceImpl;
import ru.otus.spring.service.SimpleTestingService;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuestionServiceImpl daoService = context.getBean(QuestionServiceImpl.class);
        SimpleTestingService testingService = context.getBean(SimpleTestingService.class);

        testingService.helloTesting();

        for (int i = 1; i < daoService.getQuestionListSize() + 1; i++) {
            testingService.askQuestion(daoService.getQuestionByNumber(i));
        }
        testingService.getResult();

    }
}
