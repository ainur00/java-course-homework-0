package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {
    private final static Pattern HAS_MIN_THREE_01_AND_THIRD_IS_0_PATTERN = Pattern.compile("^[01]{2}0[01]*");

    private final static Pattern STARTS_AND_ENDS_WITH_0_PATTERN = Pattern.compile("^0[01]*0$");

    private final static Pattern STARTS_AND_ENDS_WITH_1_PATTERN = Pattern.compile("^1[01]*1$");

    private final static Pattern HAS_MIN_ONE_01_AND_MAX_THREE_01_PATTERN = Pattern.compile("^[01]{1,3}$");

    public Boolean hasMinThree01AndThirdIs0(String line) {
        if (line == null) {
            return false;
        }
        return HAS_MIN_THREE_01_AND_THIRD_IS_0_PATTERN.matcher(line).matches();
    }

    public Boolean startsAndEndsWithSameSymbol(String line) {
        if (line == null) {
            return false;
        }
        return STARTS_AND_ENDS_WITH_0_PATTERN.matcher(line).matches()
            || STARTS_AND_ENDS_WITH_1_PATTERN.matcher(line).matches();
    }

    public Boolean hasMinOne01AndMaxThree01(String line) {
        if (line == null) {
            return false;
        }
        return HAS_MIN_ONE_01_AND_MAX_THREE_01_PATTERN.matcher(line).matches();
    }
}
