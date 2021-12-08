package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.QuestionServiceImpl;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        QuestionServiceImpl daoService = context.getBean(QuestionServiceImpl.class);

        daoService.readAllQuestions();

    }
}
