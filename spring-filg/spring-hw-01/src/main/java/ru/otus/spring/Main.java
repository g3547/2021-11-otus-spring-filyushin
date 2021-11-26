package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.QuestionServiceImpl;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        QuestionServiceImpl daoService = context.getBean(QuestionServiceImpl.class);

        for (int i = 1; i < daoService.getQuestionListSize()+1; i++) {
            System.out.println(daoService.getQuestionByNumber(i));
        }

    }
}
