package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Question;

@Component
public class SimpleTestingService implements TestingService {

    private String studentName;
    private int actualScore;
    private final QuestionService questionService;
    private final AnswerReader answerReader;

    private final int scoreToPass;

    public SimpleTestingService(@Value("${testing.score}") int scoreToPass,
                                QuestionService questionService,
                                AnswerReader answerReader) {
        this.scoreToPass = scoreToPass;
        this.questionService = questionService;
        this.answerReader = answerReader;
    }

    @Override
    public void helloTesting() {
        System.out.println("print your name");
        studentName = answerReader.reedLine();
        System.out.println(String.format("Hi, %s, lets start testing", studentName));
    }

    @Override
    public void askQuestion(Question question) {
        System.out.println(question.getQuestion());
        String answer = answerReader.reedLine();
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

    @Override
    public void testStudent() {
        helloTesting();

        for (int i = 1; i < questionService.getQuestionListSize() + 1; i++) {
            askQuestion(questionService.getQuestionByNumber(i));
        }

        System.out.println(getResult());

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
