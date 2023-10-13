package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task1Test {

    @BeforeEach
    void setUp() {
        task1 = new Task1();
    }

    private Task1 task1;

    @Test
    void giveIncorrectTimeShouldReturnMinusOne() {
        String time = "incorrect-time";
        Long response = task1.getSecondsCount(time);
        Assertions.assertThat(response).isEqualTo(-1L);
    }

    @Test
    void giveCorrectTimeShouldReturnTimeInSeconds() {
        String time = "4242:42";
        Long response = task1.getSecondsCount(time);
        Assertions.assertThat(response).isEqualTo(254562L);
    }
}
