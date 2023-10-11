package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class Task5Test {
    Task5 task5;
    @BeforeEach
    void setUp() {
        task5 = new Task5();
    }

    @Test
    void givePalindromeDescendantShouldReturnTrue() {
        Long number = 11211230L;
        Boolean response = task5.isPalindromeDescendant(number);
        Assertions.assertThat(response).isEqualTo(true);
    }

    @Test
    void giveNoPalindromeDescendantShouldReturnFalse() {
        Long number = 11211231L;
        Boolean response = task5.isPalindromeDescendant(number);
        Assertions.assertThat(response).isEqualTo(false);
    }

    @Test
    void giveDigitShouldReturnFalse() {
        Long number = 0L;
        Boolean response = task5.isPalindromeDescendant(number);
        Assertions.assertThat(response).isEqualTo(false);
    }
}
