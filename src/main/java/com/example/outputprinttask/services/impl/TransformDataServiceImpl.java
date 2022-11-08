package com.example.outputprinttask.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.outputprinttask.dto.OutputMessageDto;
import com.example.outputprinttask.services.TransformDataService;
import com.example.outputprinttask.utils.OutputTransformerUtils;

@Service
public class TransformDataServiceImpl implements TransformDataService {

    private static final String REGEXP = "[^aeiou]";
    private List<OutputMessageDto> outputMessageDtosWithoutDuplicates = new ArrayList<>();


    @Override
    public List<String> transformOutputData(List<String> data) throws IOException {
        assert data != null;
        List<OutputMessageDto> outputMessageDtos = data.stream().map(this::findVowels).collect(Collectors.toList());
        outputMessageDtos.forEach(this::findDuplicates);
        return outputMessageDtosWithoutDuplicates.stream().sorted(Comparator.comparingDouble(OutputMessageDto::getAverageCount))
                .sorted((o1, o2) -> o2.getVowelsCount() - o1.getVowelsCount())
                .map(OutputTransformerUtils::messageTransform).collect(Collectors.toList());
    }

    private OutputMessageDto findVowels(String word) {
        String[] chars = word.toLowerCase().replaceAll(REGEXP, "").split("");
        List<String> collect = Arrays.stream(chars).sorted().distinct().collect(Collectors.toList());
        return new OutputMessageDto(collect, word.length(), chars.length);
    }

    private void  findDuplicates(OutputMessageDto dto) {
        if (outputMessageDtosWithoutDuplicates.contains(dto)) {
            int indexOfDto = outputMessageDtosWithoutDuplicates.indexOf(dto);
            OutputMessageDto containedDto = outputMessageDtosWithoutDuplicates.get(indexOfDto);
            double sumOfAverageCount = (double) ((dto.getAverageCount() + containedDto.getAverageCount()) / 2);
            containedDto.setAverageCount(sumOfAverageCount);
        } else {
            outputMessageDtosWithoutDuplicates.add(dto);
        }
    }
}
