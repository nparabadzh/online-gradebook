package com.example.onlinegradebook.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.example.onlinegradebook.model")
@SpringBootApplication()
public class OnlineGradebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineGradebookApplication.class, args);
    }

}
