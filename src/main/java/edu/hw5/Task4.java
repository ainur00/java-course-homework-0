package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    private final static Pattern PASSWORD_SPECIAL_SYMBOLS_PATTERN = Pattern.compile("\\w*[~!@#$%^&*|]+.+");

    public Boolean isPasswordHasSpecialSymbols(String password) {
        if (password == null) {
            return false;
        }
        return PASSWORD_SPECIAL_SYMBOLS_PATTERN.matcher(password).matches();
    }
}
