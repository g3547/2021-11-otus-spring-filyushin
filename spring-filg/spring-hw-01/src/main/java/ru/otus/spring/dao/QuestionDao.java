package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;

public interface QuestionDao {

    public Question getQuestionByNumber(int questionNumber);
    public int getQuestionListSize();
}
