package com.example.outputprinttask.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.outputprinttask.services.FileLoaderService;
import com.example.outputprinttask.services.FileWriterService;
import com.example.outputprinttask.services.MainOutputService;
import com.example.outputprinttask.services.TransformDataService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MainOutputServiceImpl implements MainOutputService {

    @Value("${project.input.fileName}")
    private String inputFileName;

    @Value("${project.output.fileName}")
    private String outputFileName;

    private final FileWriterService fileWriterService;
    private final FileLoaderService fileLoaderService;
    private final TransformDataService transformDataService;

    @Autowired
    public MainOutputServiceImpl(FileWriterService fileWriterService, FileLoaderService fileLoaderService,
            TransformDataService transformDataService) {
        this.fileWriterService = fileWriterService;
        this.fileLoaderService = fileLoaderService;
        this.transformDataService = transformDataService;
    }

    @PostConstruct
    public void init() throws IOException {
        Files.deleteIfExists(Paths.get(outputFileName));
        Files.createFile(Paths.get(outputFileName));
        log.info("File {} have been created", outputFileName);
    }

    @Override
    public void writeOutputData() throws IOException {
        List<String> fileData = this.fileLoaderService.loadFileByName(inputFileName);
        List<String> transformOutputData = this.transformDataService.transformOutputData(fileData);
        this.fileWriterService.writeOutputDataToFile(outputFileName, transformOutputData);
    }
}
