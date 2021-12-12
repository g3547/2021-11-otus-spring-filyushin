package ru.otus.spring.service;

import ru.otus.spring.domain.Question;

public interface TestingService {
    public String getResult();
    public void askQuestion(Question question);
    public boolean testStudent();
    public boolean validateAnswer(Question question, String answer);
    public int getActualScore();

}
