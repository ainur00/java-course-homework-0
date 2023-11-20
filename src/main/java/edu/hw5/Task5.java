package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {
    private final static Pattern RUSSIAN_LICENSE_PLATES_PATTERN = Pattern.compile("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$");

    public Boolean isRussianLicensePlate(String line) {
        if (line == null) {
            return false;
        }
        return RUSSIAN_LICENSE_PLATES_PATTERN.matcher(line).matches();
    }
}
