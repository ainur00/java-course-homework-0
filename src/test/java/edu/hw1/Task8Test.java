package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class Task8Test {
    Task8 task8;

    @BeforeEach
    void setUp() {
        task8 = new Task8();
    }

    @Test
    void giveBoardShouldReturnAreKnightesInSafety() {
        Boolean[][] board = {
            {false, false, false, false, true, false, false, false},
            {false, false, false, false, false, true, false, false},
            {false, false, false, true, false, false, false, false},
            {true, false, false, false, false, false, false, false},
            {false, false, false, false, true, false, false, false},
            {false, false, false, false, false, true, false, false},
            {false, false, false, false, false, true, false, false},
            {true, false, false, false, false, false, false, false}
        };
        Boolean response = task8.areKnightesInSafety(board);
        Assertions.assertThat(response).isEqualTo((Boolean) false);
    }

    @Test
    void giveBoardWithoutKnightesShouldReturnTrue() {
        Boolean[][] board = {
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false}
        };
        Boolean response = task8.areKnightesInSafety(board);
        Assertions.assertThat(response).isEqualTo((Boolean) true);
    }
}
