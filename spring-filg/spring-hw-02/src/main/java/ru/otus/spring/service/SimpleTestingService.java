package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Question;

import java.util.Scanner;

@Component
public class SimpleTestingService implements TestingService {

    private String studentName;
    private int actualScore;

    public SimpleTestingService(@Value("${testing.score}") int scoreToPass) {
        this.scoreToPass = scoreToPass;
    }

    private final int scoreToPass;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void helloTesting() {
        System.out.println("print your name");
        studentName = scanner.next();
        System.out.println(String.format("Hi, %s, lets start testing", studentName));
    }

    @Override
    public void askQuestion(Question question) {
        System.out.println(question.getQuestion());
        String answer = scanner.next();
        boolean isCorrect = validateAnswer(question, answer);
        System.out.println(String.format("Your answer is %s", transformText(isCorrect)));
        System.out.println("---");

    }

    @Override
    public String getResult() {
        if (this.actualScore >= this.scoreToPass)
            return String.format("Congratulations! You scored %s / %s", actualScore, scoreToPass);
        else
            return String.format("You failed! You scored %s / %s", actualScore, scoreToPass);
    }

    private String transformText(boolean isCorrect) {
        if (isCorrect) return "Correct";
        else return "Not Correct";
    }

    private boolean validateAnswer(Question question, String answer) {
        if (question.getRightAnswer().equals(answer)) {
            this.actualScore += 2;
            return true;
        } else this.actualScore -= 1;
        return false;
    }
}
