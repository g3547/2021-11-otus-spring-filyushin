package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.service.QuestionServiceImpl;
@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        QuestionServiceImpl daoService = context.getBean(QuestionServiceImpl.class);

        for (int i = 1; i < daoService.getQuestionListSize()+1; i++) {
            System.out.println(daoService.getQuestionByNumber(i));
        }

    }
}
