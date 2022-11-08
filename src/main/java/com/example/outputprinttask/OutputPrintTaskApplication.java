package com.example.outputprinttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.outputprinttask.services.impl.MainOutputServiceImpl;

@SpringBootApplication
public class OutputPrintTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutputPrintTaskApplication.class, args);
    }
}
