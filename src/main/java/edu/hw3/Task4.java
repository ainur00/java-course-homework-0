package edu.hw3;

import java.util.HashMap;

public class Task4 {
    private final static Short[] CONVERSION_ORDER = new Short[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] ROMAN_CONVERSION_ORDER =
        new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static HashMap<Short, String> getRomanConverter() {
        HashMap<Short, String> converter = new HashMap<Short, String>();
        for (int i = 0; i < CONVERSION_ORDER.length; ++i) {
            converter.put(CONVERSION_ORDER[i], ROMAN_CONVERSION_ORDER[i]);
        }
        return converter;
    }

    public String getConvertedToRoman(Integer num) {
        HashMap<Short, String> romanConverter = getRomanConverter();
        String numRoman = "";
        int numCopy = num;
        for (Short currentConversionNum : CONVERSION_ORDER) {
            while (numCopy >= currentConversionNum) {
                numRoman = numRoman.concat(romanConverter.get(currentConversionNum));
                numCopy -= currentConversionNum;
            }
        }
        return numRoman;
    }
}
