package ru.otus.spring.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.AnswerReader;
import ru.otus.spring.service.LocalizationService;
import ru.otus.spring.service.QuestionService;
import ru.otus.spring.service.TestingService;

import javax.annotation.PostConstruct;

@Component
public class SimpleTestingService implements TestingService {

    private String studentName;
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
    public void helloTesting() {
        String name = localService.getLocalString("fill-in.name");
        System.out.println(name);

        studentName = answerReader.reedLine();

        String hello = localService.getLocalString("strings.hello",studentName);
        System.out.println(hello);
    }

    @Override
    public void askQuestion(Question question) {
        System.out.println(localService.getLocalString("strings.ask"));
        System.out.println(question.getQuestion());
        String answer = answerReader.reedLine();
        boolean isCorrect = validateAnswer(question, answer);
        System.out.println(localService.getLocalString("strings.answer", transformText(isCorrect)));
        System.out.println("---");

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
    @PostConstruct
    public void testStudent() {
        helloTesting();

        for (int i = 1; i < questionService.getQuestionListSize() + 1; i++) {
            askQuestion(questionService.getQuestionByNumber(i));
        }

        System.out.println(getResult());

    }

    private String transformText(boolean isCorrect) {
        if (isCorrect) return localService.getLocalString("strings.correct");
        else return localService.getLocalString("strings.not-correct");
    }

    private boolean validateAnswer(Question question, String answer) {
        if (question.getRightAnswer().equals(answer)) {
            this.actualScore += 2;
            return true;
        } else this.actualScore -= 1;
        return false;
    }
}
