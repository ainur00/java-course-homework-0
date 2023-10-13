package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task2Test {
    Task2 task2;

    @BeforeEach
    void setUp() {
        task2 = new Task2();
    }
    @Test
    void giveNumShouldReturnNumDigitsCount() {
        Long num = 123456789L;
        Byte response = task2.getDigitsCount(num);
        Assertions.assertThat(response).isEqualTo((byte)9);
    }

    @Test
    void giveNullShouldReturnOne() {
        Long num = 0L;
        Byte response = task2.getDigitsCount(num);
        Assertions.assertThat(response).isEqualTo((byte)1);
    }
}
