package edu.hw1;

public class Task4 {
    public String getFixedString(String brokenLine) {
        char[] line = brokenLine.toCharArray();
        for (int i = 0; i < getEvenLength(line); i += 2) {
            char temp = line[i];
            line[i] = line[i + 1];
            line[i + 1] = temp;
        }
        return String.valueOf(line);
    }

    private Long getEvenLength(char[] line) {
        return (long) (line.length - (line.length % 2));
    }
}
