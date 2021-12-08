package ru.otus.spring.domain;

import java.util.Objects;

public class Question {
    private final int questionNumber;
    private final String question;
    private final String rightAnswer;

    public String getQuestion() {
        return question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public Question(String questionNumber, String question, String rightAnswer) {
        this.questionNumber = Integer.parseInt(questionNumber);
        this.question = question;
        this.rightAnswer = rightAnswer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public boolean validateAnswer(String answer) {
        return this.rightAnswer.equals(answer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return questionNumber == question1.questionNumber && question.equals(question1.question) && rightAnswer.equals(question1.rightAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionNumber, question, rightAnswer);
    }

    @Override
    public String toString() {
        return question;
    }
}
