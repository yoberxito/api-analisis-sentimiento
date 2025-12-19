package com.hackathon.sentiment.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentimentApiApplication {

    public static void main(String[] args) {
        System.out.println("Hola");
        SpringApplication.run(SentimentApiApplication.class, args);
    }
}
