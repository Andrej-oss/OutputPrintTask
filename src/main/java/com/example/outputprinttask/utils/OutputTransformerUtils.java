package com.example.outputprinttask.utils;

import java.util.List;
import java.util.StringJoiner;

import com.example.outputprinttask.dto.OutputMessageDto;

public class OutputTransformerUtils {

    private static final String COMA_DELIMITER = ", ";
    private static final String ARROW_DELIMITER = ") -> ";
    private static final String LEFT_CURLY_BRACKET = "({";
    private static final String RIGHT_CURLY_BRACKET = "}";

    public static String messageTransform(OutputMessageDto dto) {
        if (dto != null) {
            String transformListChars = transformListChars(dto.getChars());
            return new StringBuilder(transformListChars).append(COMA_DELIMITER)
                    .append(dto.getVowelsCount())
                    .append(ARROW_DELIMITER)
                    .append(dto.getAverageCount())
                    .toString();
        } else {
            return "";
        }
    }

    private static String transformListChars(List<String> chars) {
        if (!chars.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder(LEFT_CURLY_BRACKET);
            StringJoiner charJoiner = new StringJoiner(COMA_DELIMITER);
            chars.forEach(charJoiner::add);
            stringBuilder.append(charJoiner).append(RIGHT_CURLY_BRACKET);
            return stringBuilder.toString();
        } else {
            return "";
        }
    }
}
