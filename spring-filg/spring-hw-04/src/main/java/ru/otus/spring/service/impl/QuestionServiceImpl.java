package ru.otus.spring.service.impl;

import org.springframework.stereotype.Component;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.QuestionService;

@Component
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public int getQuestionListSize() {
        return questionDao.getQuestionListSize();
    }

    @Override
    public Question getQuestionByNumber(int questionNumber) {
        return questionDao.getQuestionByNumber(questionNumber);
    }

    @Override
    public void readAllQuestions() {
        for (int i = 1; i < getQuestionListSize() + 1; i++) {
            System.out.println(getQuestionByNumber(i));
        }
    }
}
