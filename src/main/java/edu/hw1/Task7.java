package edu.hw1;

public class Task7 {
    private final static Byte BINARY_RADIX = 2;

    public Long rotateLeft(Long number, Integer shift) {
        if (shift < 0)
            return rotateRight(number, -shift);
        char[] numBits = Long.toString(number, BINARY_RADIX).toCharArray();
        int realShift = shift % numBits.length;
        charArrayHalvesSwap(numBits, realShift);
        return Long.parseLong(String.valueOf(numBits), BINARY_RADIX);
    }

    public Long rotateRight(Long number, Integer shift) {
        if (shift < 0)
            return rotateLeft(number, -shift);
        char[] numBits = Long.toString(number, BINARY_RADIX).toCharArray();
        int realShift = shift % numBits.length;
        charArrayHalvesSwap(numBits, numBits.length - realShift);
        return Long.parseLong(String.valueOf(numBits), BINARY_RADIX);
    }

    private void charArrayHalvesSwap(char[] arr, Integer separator) {
        char[] leftPart = new char[separator];
        System.arraycopy(arr, 0, leftPart, 0, leftPart.length);
        char[] rightPart = new char[arr.length - separator];
        System.arraycopy(arr, leftPart.length, rightPart, 0, rightPart.length);
        System.arraycopy(rightPart, 0, arr, 0, rightPart.length);
        System.arraycopy(leftPart, 0, arr, rightPart.length, leftPart.length);
    }
}
