package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//http://localhost:8080
//http://localhost:8080/edit?id=1
@SpringBootApplication
public class LibraryTask {

    public static void main(String[] args) {
        SpringApplication.run(LibraryTask.class, args);
    }

}
