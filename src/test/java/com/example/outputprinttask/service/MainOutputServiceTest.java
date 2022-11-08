package com.example.outputprinttask.service;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.example.outputprinttask.services.FileLoaderService;
import com.example.outputprinttask.services.FileWriterService;
import com.example.outputprinttask.services.MainOutputService;
import com.example.outputprinttask.services.TransformDataService;
import com.example.outputprinttask.services.impl.MainOutputServiceImpl;

public class MainOutputServiceTest {

    private static final List<String> INPUT_DATA = Arrays.asList("Platon", "made", "bamboo", "boats");
    private static final List<String> EXPECTED_DATA = Arrays.asList("({a, o}, 6) -> 2.5", "({a, e}, 4) -> 2.0",
            "({a, o}, 5) -> 2.0");

    @Test
    public void shouldSuccessfulWriteOutputDataAllServicesWhenGiven() throws IOException {
        //given
        FileWriterService fileWriterService = mock(FileWriterService.class);
        TransformDataService transformDataService = mock(TransformDataService.class);
        FileLoaderService fileLoaderService = mock(FileLoaderService.class);

        MainOutputService mainOutputService = new MainOutputServiceImpl(fileWriterService, fileLoaderService, transformDataService);

        // when
        when(fileLoaderService.loadFileByName(anyString())).thenReturn(INPUT_DATA);
        when(transformDataService.transformOutputData(anyList())).thenReturn(EXPECTED_DATA);

        mainOutputService.writeOutputData();
    }
}
