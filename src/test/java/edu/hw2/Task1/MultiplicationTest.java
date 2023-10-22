package edu.hw2.Task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MultiplicationTest {
    @Test
    void giveNumbersShouldCalculateMultiplication() {
        double multiplier1 = 4;
        double multiplier2 = 2;
        var multiplicationNumber = new Multiplication(multiplier1, multiplier2);
        Assertions.assertThat(multiplicationNumber.evaluate()).isEqualTo(8d);
    }
}
