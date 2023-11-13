package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    public Boolean isSubsequence(String line, String text) {
        if (line == null || text == null) {
            return false;
        }
        Pattern isLineSubsequencePattern = Pattern.compile(".*" + line + ".*");
        return isLineSubsequencePattern.matcher(text).matches();
    }
}
