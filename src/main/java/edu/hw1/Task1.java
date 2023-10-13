package edu.hw1;

public class Task1 {
    private final static Byte SECONDS_IN_MINUTE = 60;
    private final static Byte DECIMAL_RADIX = 10;
    private final static Byte ERROR_CODE = -1;

    public Long getSecondsCount(String time) {
        if (!isTimeCorrect(time)) {
            return (long) ERROR_CODE;
        }
        String[] timeSplit = time.split(":");
        long minutes = Long.parseLong(timeSplit[0], DECIMAL_RADIX);
        long seconds = Long.parseLong(timeSplit[1], DECIMAL_RADIX);
        return SECONDS_IN_MINUTE * minutes + seconds;
    }

    private final static Byte COLON_POS_FROM_END = 2;
    private final static Byte SECONDS_TENS_LIMIT = 6;

    private Boolean isTimeCorrect(String time) {
        // minutes value check
        for (int i = 0; i < time.length() - COLON_POS_FROM_END - 1; ++i) {
            if (!Character.isDigit(time.charAt(i))) {
                return false;
            }
        }
        // colon check
        if (time.charAt(time.length() - COLON_POS_FROM_END - 1) != ':') {
            return false;
        }
        // seconds value check
        int secondsValuePos = time.length() - COLON_POS_FROM_END;
        return (Character.isDigit(time.charAt(secondsValuePos)))
            && (Character.isDigit(time.charAt(secondsValuePos + 1)))
            && (time.charAt(secondsValuePos) - '0' < SECONDS_TENS_LIMIT);
    }
}
