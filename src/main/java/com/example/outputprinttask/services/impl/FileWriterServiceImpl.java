package com.example.outputprinttask.services.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.outputprinttask.services.FileWriterService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileWriterServiceImpl implements FileWriterService {

    private static final String PARAGRAPH = "\n";

    @Override
    public void writeOutputDataToFile(String fileName, List<String> outputData) throws IOException {
        assert outputData != null || fileName != null;
        FileWriter fileWriter = new FileWriter(fileName);
        for (String data : outputData) {
            fileWriter.write(data);
            fileWriter.write(PARAGRAPH);
        }
        fileWriter.close();
        log.info("Data has been written successful");
    }
}
