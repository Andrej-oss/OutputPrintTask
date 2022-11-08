package com.example.outputprinttask.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.outputprinttask.services.impl.TransformDataServiceImpl;

public class TransformDataServiceTest {

    private static final List<String> INPUT_DATA = Arrays.asList("platon", "made", "bamboo", "boats");
    private static final List<String> EXPECTED_DATA = Arrays.asList("({a, o}, 6) -> 2.5", "({a, o}, 5) -> 2.0",
            "({a, e}, 4) -> 2.0");
    private TransformDataServiceImpl dataService = new TransformDataServiceImpl();

    @Test
    public void shouldTransformOutputDataWhenGivenInputData() throws IOException {
        //when;
        List<String> strings = dataService.transformOutputData(INPUT_DATA);

        //then
        assertThat(strings).isNotEmpty();
        assertThat(strings.size()).isEqualTo(EXPECTED_DATA.size());
        assertThat(strings.get(0)).isEqualTo(EXPECTED_DATA.get(0));
        assertThat(strings.get(strings.size() - 1)).isEqualTo(EXPECTED_DATA.get(EXPECTED_DATA.size() - 1));
    }

    @Test
    public void shouldThrowAssertionExceptionWhenGivenEmptyInputData() throws IOException {
        //when & then;
        assertThatThrownBy(() -> dataService.transformOutputData(null)).isInstanceOf(AssertionError.class);

    }
}
