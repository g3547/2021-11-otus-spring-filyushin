package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoFromCsv implements QuestionDao {
    private final String sourceFile;
    private List<Question> questionList;
    private List<String> stringDataList;

    public QuestionDaoFromCsv(String filePath) {
        this.sourceFile = filePath;
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

    private List<String> reedCsvFile() {
        stringDataList = new ArrayList<>();
        try (BufferedReader reader = initReader()) {
            String line = reader.readLine();
            while (line != null) {
                stringDataList.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("file path error", e);
        }
        return stringDataList;
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
            stringDataList = reedCsvFile();
        }
        if (questionList == null) {
            questionList = fillInQuestions();
        }
    }

    private BufferedReader initReader() {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(this.sourceFile);
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);

        return new BufferedReader(streamReader);
    }

}
