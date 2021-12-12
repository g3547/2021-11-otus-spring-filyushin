package ru.otus.spring.dao;

import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Question;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionDaoFromCsv implements QuestionDao {
    private final CsvFileReader reader;
    private List<Question> questionList;
    private List<String> stringDataList;

    public QuestionDaoFromCsv(CsvFileReader csvFileReader) {
        this.reader = csvFileReader;
    }

    @Override
    public int getQuestionListSize() {
        initDataFromFile();
        return this.questionList.size();
    }

    @Override
    public Question getQuestionByNumber(int questionNumber) {
        initDataFromFile();
        for (Question question : questionList) {
            if (question.getQuestionNumber() == questionNumber) return question;
        }
        throw new RuntimeException("Didn't find question");
    }


    private List<Question> fillInQuestions() {
        questionList = new ArrayList<>();

        for (String line : stringDataList) {
            String[] questions = line.split(",");
            questionList.add(new Question(questions[0], questions[1], questions[2]));
        }
        return questionList;
    }

    private void initDataFromFile() {
        if (stringDataList == null) {
            stringDataList = reader.reedCsvFile();
        }
        if (questionList == null) {
            questionList = fillInQuestions();
        }
    }


}
