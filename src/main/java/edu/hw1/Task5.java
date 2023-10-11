package edu.hw1;

public class Task5 {
    public Boolean isPalindromeDescendant(Long number) {
        char[] numberChars = number.toString().toCharArray();
        int[] numberDigits = new int[numberChars.length];
        for (int i = 0; i < numberDigits.length; ++i) {
            numberDigits[i] = numberChars[i] - '0';
        }
        return isPalindromeDescendant(numberDigits, numberDigits.length);
    }

    private final static Byte DECIMAL_RADIX = 10;

    private Boolean isPalindromeDescendant(int[] number, int currentLength) {
        if (!isPalindrome(number, currentLength) && currentLength > 1) {
            int newLength = 0;
            for (int i = 0; i < getEvenLength(currentLength); i += 2) {
                int twoSum = number[i] + number[i + 1];
                if (twoSum > DECIMAL_RADIX - 1) {
                    number[newLength++] = twoSum / DECIMAL_RADIX;
                    number[newLength++] = twoSum % DECIMAL_RADIX;
                } else {
                    number[newLength++] = twoSum;
                }
            }
            return isPalindromeDescendant(number, newLength);
        }
        return currentLength != 1;
    }

    private int getEvenLength(int length) {
        return length - (length % 2);
    }

    private Boolean isPalindrome(int[] line, int currentLength) {
        for (int i = 0; i < currentLength / 2; ++i) {
            if (line[i] != line[currentLength - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
