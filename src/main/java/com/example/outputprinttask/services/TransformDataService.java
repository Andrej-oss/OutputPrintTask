package com.example.outputprinttask.services;

import java.io.IOException;
import java.util.List;

public interface TransformDataService {

    List<String> transformOutputData(List<String> data) throws IOException;
}
