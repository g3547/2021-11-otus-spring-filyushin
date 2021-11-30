package ru.otus.spring.dao;

import java.io.BufferedReader;
import java.util.List;

public interface FileReader {
    public List<String> reedCsvFile() ;
    public BufferedReader initReader();

    }
