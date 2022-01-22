package ru.otus.spring;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMongock
@SpringBootApplication
public class LibraryTask {

    public static void main(String[] args) {
        SpringApplication.run(LibraryTask.class, args);
    }

}
