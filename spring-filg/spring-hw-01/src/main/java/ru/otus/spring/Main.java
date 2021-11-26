package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.dao.QuestionDaoFromCsv;
import ru.otus.spring.domain.Question;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        QuestionDaoFromCsv daoFromCsv = context.getBean(QuestionDaoFromCsv.class);

        for (int i = 1; i < daoFromCsv.getQuestionListSize()+1; i++) {
            System.out.println(daoFromCsv.getQuestionByNumber(i));
        }

    }
}
