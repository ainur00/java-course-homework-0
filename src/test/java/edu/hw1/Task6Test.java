package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class Task6Test {
    Task6 task6;
    @BeforeEach
    void setUp() {
        task6 = new Task6();
    }

    @Test
    void giveNumShouldReturnStepsCount() {
        Integer number = 1234;
        Byte response = task6.getCountK(number);
        Assertions.assertThat(response).isEqualTo((byte) 3);
    }

    @Test
    void giveSingleDigitNumShouldReturnMinusOne() {
        Integer number = 5555;
        Byte response = task6.getCountK(number);
        Assertions.assertThat(response).isEqualTo((byte) -1);
    }

    @Test
    void giveNumLess1001ShouldReturnMinusOne() {
        Integer number = 42;
        Byte response = task6.getCountK(number);
        Assertions.assertThat(response).isEqualTo((byte) -1);
    }
}
