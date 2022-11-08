package com.example.outputprinttask.services;

import java.io.IOException;
import java.util.List;

public interface FileLoaderService {

    List<String> loadFileByName(String name) throws IOException;
}
