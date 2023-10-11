package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class Task7Test {
    Task7 task7;

    @BeforeEach
    void setUp() {
        task7 = new Task7();
    }

    @Test
    void giveNumAndShiftShouldReturnLeftShiftedNum() {
        Long number = 17L;
        Integer shift = 2;
        Long response = task7.rotateLeft(number, shift);
        Assertions.assertThat(response).isEqualTo(6);
    }

    @Test
    void giveNumAndShiftShouldReturnRightShiftedNum() {
        Long number = 8L;
        Integer shift = 1;
        Long response = task7.rotateRight(number, shift);
        Assertions.assertThat(response).isEqualTo(4);
    }

    @Test
    void giveNullShouldReturnNullLeftRotate() {
        Long number = 0L;
        Integer shift = Integer.MAX_VALUE;
        Long response = task7.rotateLeft(number, shift);
        Assertions.assertThat(response).isEqualTo(0);
    }

    @Test
    void giveNullShouldReturnNullRightRotate() {
        Long number = 0L;
        Integer shift = Integer.MAX_VALUE;
        Long response = task7.rotateRight(number, shift);
        Assertions.assertThat(response).isEqualTo(0);
    }

    @Test
    void giveNumAndNullShiftShouldReturnNum() {
        Long number = Long.MAX_VALUE;
        Integer shift = 0;
        Long response = task7.rotateRight(number, shift);
        Assertions.assertThat(response).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void giveNumAndNegativeShiftShouldReturnLeftShiftedNum() {
        Long number = 8L;
        Integer shift = -1;
        Long response = task7.rotateLeft(number, shift);
        Assertions.assertThat(response).isEqualTo(4);
    }

    @Test
    void giveNumAndNegativeShiftShouldReturnRightShiftedNum() {
        Long number = 17L;
        Integer shift = -2;
        Long response = task7.rotateRight(number, shift);
        Assertions.assertThat(response).isEqualTo(6);
    }
}
