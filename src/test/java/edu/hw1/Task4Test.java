package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task4Test {
    private Task4 task4;

    @BeforeEach
    void setUp() {
        task4 = new Task4();
    }

    @Test
    void giveEvenLengthLineShouldReturnFixedLine() {
        String brokenLine = "hTsii  s aimex dpus rtni.g";
        String response = task4.getFixedString(brokenLine);
        Assertions.assertThat(response).isEqualTo("This is a mixed up string.");
    }

    @Test
    void giveOddLengthLineShouldReturnFixedLine() {
        String brokenLine = "badce";
        String response = task4.getFixedString(brokenLine);
        Assertions.assertThat(response).isEqualTo("abcde");
    }

    @Test
    void giveEmptyLineShouldReturnEmptyLine() {
        String brokenLine = "";
        String response = task4.getFixedString(brokenLine);
        Assertions.assertThat(response).isEqualTo("");
    }
}
