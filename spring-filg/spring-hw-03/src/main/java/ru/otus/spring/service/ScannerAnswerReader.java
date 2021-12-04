package ru.otus.spring.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerAnswerReader implements AnswerReader{

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String reedLine() {
        return scanner.next();
    }
}
