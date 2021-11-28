package ru.otus.spring.service;

import ru.otus.spring.domain.Question;

public interface TestingService {
    public void helloTesting();
    public void askQuestion(Question question);
    public String getResult();
}
