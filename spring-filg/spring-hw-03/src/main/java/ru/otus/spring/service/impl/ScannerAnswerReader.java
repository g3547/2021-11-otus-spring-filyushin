package ru.otus.spring.service.impl;

import org.springframework.stereotype.Component;
import ru.otus.spring.service.AnswerReader;

import java.util.Scanner;

@Component
public class ScannerAnswerReader implements AnswerReader {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String reedLine() {
        return scanner.next();
    }
}
