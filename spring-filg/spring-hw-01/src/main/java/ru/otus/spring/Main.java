package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.dao.PersonDaoSimple;
import ru.otus.spring.domain.Person;

public class Main {

    public static void main(String[] args) {
        // TODO: создайте здесь класс контекста
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        // TODO: Получите Person Service
        PersonDaoSimple personDaoSimple = context.getBean(PersonDaoSimple.class);
        // Получите Person "Ivan"
        Person ivan = personDaoSimple.findByName("Ivan");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }
}
