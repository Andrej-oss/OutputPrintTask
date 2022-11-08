package com.example.outputprinttask.services.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.outputprinttask.services.FileLoaderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileLoaderServiceImpl implements FileLoaderService {

    private static final String REGEXP_DELIMITER = "\\.";

    @Override
    public List<String> loadFileByName(String name) throws IOException {
        assert name != null;
        BufferedReader fileReader = new BufferedReader(new FileReader(name));
        log.info("File {} have been loaded", name);
        return Arrays.stream(fileReader.readLine()
                .replaceAll(REGEXP_DELIMITER,"").split(" ")).collect(Collectors.toList());
    }
}
