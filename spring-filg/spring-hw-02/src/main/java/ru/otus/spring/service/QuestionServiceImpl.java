package ru.otus.spring.service;

import org.springframework.stereotype.Component;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;
@Component
public class QuestionServiceImpl implements QuestionService {
    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    private final QuestionDao questionDao;

    @Override
    public int getQuestionListSize() {
        return questionDao.getQuestionListSize();
    }

    @Override
    public Question getQuestionByNumber(int questionNumber) {
        return questionDao.getQuestionByNumber(questionNumber);
    }
}
