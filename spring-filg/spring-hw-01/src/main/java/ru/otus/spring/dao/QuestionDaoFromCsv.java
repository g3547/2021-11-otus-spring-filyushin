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

    public QuestionDaoFromCsv(String filePath) {
        this.sourceFile = filePath;
        this.reedCsv();
    }

    public int getQuestionListSize(){
        return this.questionList.size();
    }

    public Question getQuestionByNumber(int questionNumber) {

        for (Question question : questionList) {
            if (question.getQuestionNumber() == questionNumber) return question;
        }
        throw new RuntimeException("Didn't find question");
    }

    private void reedCsv() {
        questionList = new ArrayList<>();
        String line;
        try (BufferedReader reader = initReader()) {
            line = reader.readLine();
            while (line != null) {
                String[] questions = line.split(",");
                questionList.add(new Question(questions[0], questions[1], questions[2]));
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("file path error", e);
        }
    }

    private BufferedReader initReader() {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(this.sourceFile);
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);

        return new BufferedReader(streamReader);
    }

}
