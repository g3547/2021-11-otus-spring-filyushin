package ru.otus.spring.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.AnswerReader;
import ru.otus.spring.service.LocalizationService;
import ru.otus.spring.service.QuestionService;
import ru.otus.spring.service.TestingService;

@Component
public class SimpleTestingService implements TestingService {

    private int actualScore;
    private final QuestionService questionService;
    private final AnswerReader answerReader;
    private final LocalizationService localService;


    private final int scoreToPass;


    public SimpleTestingService(@Value("${testing.score}") int scoreToPass,
                                QuestionService questionService,
                                AnswerReader answerReader, LocalizationService localService) {
        this.scoreToPass = scoreToPass;
        this.questionService = questionService;
        this.answerReader = answerReader;
        this.localService = localService;
    }


    @Override
    public void askQuestion(Question question) {
        System.out.println(localService.getLocalString("strings.ask"));
        System.out.println(question.getQuestion());

    }

    @Override
    public String getResult() {
        if (this.actualScore >= this.scoreToPass)
            return localService.getLocalString("strings.congratulations",
                    String.valueOf(actualScore),
                    String.valueOf(scoreToPass));
        else
            return localService.getLocalString("strings.failed",
                    String.valueOf(actualScore),
                    String.valueOf(scoreToPass));
    }

    @Override
    public boolean testStudent() {
        for (int i = 1; i < questionService.getQuestionListSize() + 1; i++) {
            Question question = questionService.getQuestionByNumber(i);
            askQuestion(question);
            System.out.println(localService.getLocalString("fill-in.answer"));

            String answer = answerReader.reedLine();
            validateAnswer(question,answer);
        }
        System.out.println(localService.getLocalString("strings.testing_finished"));
        return true;
    }

    private String transformText(boolean isCorrect) {
        if (isCorrect) return localService.getLocalString("strings.correct");
        else return localService.getLocalString("strings.not-correct");
    }

    @Override
    public boolean validateAnswer(Question question, String answer) {
        boolean isCorrect = question.getRightAnswer().equals(answer);
        countScore(isCorrect);
        System.out.println(localService.getLocalString("strings.answer", transformText(isCorrect)));
        System.out.println("---");
        return isCorrect;
    }

    private void countScore(boolean isAnswerCorrect) {
        if (isAnswerCorrect) {
            this.actualScore += 2;
        }
        else this.actualScore -= 1;
    }
}
