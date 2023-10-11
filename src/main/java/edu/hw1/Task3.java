package edu.hw1;

public class Task3 {
    public Boolean isNested(Long[] nested, Long[] accommodating) {
        if (nested.length == 0) {
            return true;
        }
        if (accommodating.length == 0) {
            return false;
        }
        return getMinValue(nested) > getMinValue(accommodating)
            && getMaxValue(nested) < getMaxValue(accommodating);
    }

    private Long getMaxValue(Long[] sequence) {
        Long maxValue = sequence[0];
        for (int i = 1; i < sequence.length; ++i) {
            if (sequence[i] > maxValue) {
                maxValue = sequence[i];
            }
        }
        return maxValue;
    }

    private Long getMinValue(Long[] sequence) {
        Long minValue = sequence[0];
        for (int i = 1; i < sequence.length; ++i) {
            if (sequence[i] < minValue) {
                minValue = sequence[i];
            }
        }
        return minValue;
    }

}
