package edu.hw1;

public class Task2 {
    private final static Byte RADIX = 10;

    public Byte getDigitsCount(Long num) {
        if (num == 0) {
            return 1;
        }
        long numCopy = num;
        byte digitsCount = 0;
        while (numCopy > 0) {
            numCopy /= RADIX;
            ++digitsCount;
        }
        return digitsCount;
    }
}
