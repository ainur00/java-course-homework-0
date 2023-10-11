package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public class Task6 {
    public Byte getCountK(Integer number) {
        if (!isCorrectInput(number)) {
            return -1;
        }
        char[] numberChars = number.toString().toCharArray();
        Byte[] numberDigits = new Byte[numberChars.length];
        for (int i = 0; i < numberDigits.length; ++i) {
            numberDigits[i] = (byte) (numberChars[i] - '0');
        }
        return getCountK(numberDigits, (byte) 0);
    }

    private final static Byte[] KAPREKARS_CONSTANT = new Byte[] {6, 1, 7, 4};

    private Byte getCountK(Byte[] numDigits, byte step) {
        if (Arrays.equals(numDigits, KAPREKARS_CONSTANT)) {
            return step;
        }
        Byte[] numDigitsInAscendingOrder = numDigits.clone();
        Arrays.sort(numDigitsInAscendingOrder);
        Byte[] numDigitsInDescendingOrder = numDigits.clone();
        Arrays.sort(numDigitsInDescendingOrder, Collections.reverseOrder());
        Byte[] kNum = getByteArraysDifference(numDigitsInDescendingOrder, numDigitsInAscendingOrder);
        return getCountK(kNum, (byte) (step + 1));
    }

    private final static Byte DECIMAL_RADIX = 10;

    private Byte[] getByteArraysDifference(Byte[] minuend, Byte[] subtrahend) {
        Byte[] difference = new Byte[minuend.length];
        for (int i = minuend.length - 1; i >= 0; --i) {
            // this condition can only be satisfied when "i" is greater than 0
            if (minuend[i] < subtrahend[i]) {
                minuend[i] = (byte) (minuend[i] + DECIMAL_RADIX);
                --minuend[i - 1];
            }
            difference[i] = (byte) (minuend[i] - subtrahend[i]);
        }
        return difference;
    }

    private final static Short SINGLE_DIGIT_MULTIPLIER = 1111;
    private final static Short MIN_VALID_NUMBER = 1001;

    private Boolean isCorrectInput(Integer number) {
        return (number >= MIN_VALID_NUMBER)
            && (number % SINGLE_DIGIT_MULTIPLIER != 0);
    }
}
