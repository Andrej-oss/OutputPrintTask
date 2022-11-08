package com.example.outputprinttask.services;

import java.io.IOException;
import java.util.List;

public interface FileWriterService {

    void writeOutputDataToFile(String fileName, List<String> outputData) throws IOException;
}
