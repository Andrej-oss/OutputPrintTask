package com.example.outputprinttask.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OutputMessageDto implements Comparable{

    private List<String> chars;
    private int vowelsCount;
    private double averageCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OutputMessageDto)) {
            return false;
        }

        OutputMessageDto that = (OutputMessageDto) o;

        if (getVowelsCount() != that.getVowelsCount()) {
            return false;
        }
        return getChars() != null ? getChars().equals(that.getChars()) : that.getChars() == null;
    }

    @Override
    public int hashCode() {
        int result = getChars() != null ? getChars().hashCode() : 0;
        result = 31 * result + getVowelsCount();
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
