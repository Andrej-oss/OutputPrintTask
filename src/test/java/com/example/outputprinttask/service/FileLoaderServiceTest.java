package com.example.outputprinttask.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.outputprinttask.services.FileLoaderService;
import com.example.outputprinttask.services.impl.FileLoaderServiceImpl;

public class FileLoaderServiceTest {

    private static final List<String> EXPECTING_DATA = Arrays.asList("Platon", "made", "bamboo", "boats");
    private FileLoaderService fileLoaderService = new FileLoaderServiceImpl();

    @Test
    public void shouldLoadFileWhenFileExist() throws IOException {
        //when
        List<String> strings = this.fileLoaderService.loadFileByName("INPUT.txt");

        //then
        assertThat(strings).isNotEmpty();
        assertThat(strings).hasSize(EXPECTING_DATA.size());
        assertThat(strings.get(0)).isEqualTo(EXPECTING_DATA.get(0));
        assertThat(strings.get(strings.size() - 1)).isEqualTo(EXPECTING_DATA.get(EXPECTING_DATA.size() - 1));
    }

    @Test
    public void shouldThrowAssertionExceptionWhenGivenNull() throws IOException {
        //when & then;
        assertThatThrownBy(() -> fileLoaderService.loadFileByName(null)).isInstanceOf(AssertionError.class);

    }
}
