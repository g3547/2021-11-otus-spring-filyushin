package ru.otus.spring.service;

public interface LocalizationService {
    public String getLocalString(String code,String... args);
}
