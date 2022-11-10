package com.example.outputprinttask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.outputprinttask.services.MainOutputService;

import lombok.SneakyThrows;

@Component
public class StartWriteOutputData implements ApplicationListener<ContextRefreshedEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        MainOutputService outputService = applicationContext.getBean(MainOutputService.class);
        outputService.writeOutputData();
    }
}
