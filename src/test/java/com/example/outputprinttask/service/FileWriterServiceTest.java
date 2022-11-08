package com.example.outputprinttask.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import org.testng.annotations.Test;

import com.example.outputprinttask.services.FileWriterService;
import com.example.outputprinttask.services.impl.FileWriterServiceImpl;

public class FileWriterServiceTest {

    private static final List<String> OUTPUT_DATA = Arrays.asList("({a, o}, 6) -> 2.5", "({a, o}, 5) -> 2.0",
            "({a, e}, 4) -> 2.0");
    private static final String EXPECTED_DATA = "({a, o}, 6) -> 2.5" + "\n" +
            "({a, o}, 5) -> 2.0" + "\n" +
            "({a, e}, 4) -> 2.0";

    private FileWriterService fileWriterService = new FileWriterServiceImpl();

    @Test
    public void shouldDataHasBeenWrittenWhenGivenOutputData() throws IOException {
        //when ;
        fileWriterService.writeOutputDataToFile("OUTPUT.txt", OUTPUT_DATA);

        // then
        String outputData = this.loadFileFromOutputFile("OUTPUT.txt");
        assertThat(outputData).isEqualTo(EXPECTED_DATA);
    }

    @Test
    public void shouldThrowAssertionExceptionWhenGivenEmptyOutputData() throws IOException {
        //when;
        assertThatThrownBy(() -> fileWriterService.writeOutputDataToFile(null, null))
                .isInstanceOf(AssertionError.class);

    }

    private String loadFileFromOutputFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringJoiner joiner = new StringJoiner("\n");
        reader.lines().forEach(joiner::add);
        return joiner.toString();
    }

}
