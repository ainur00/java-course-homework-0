package edu.hw2.Task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExponentTest {
    @Test
    void giveNumbersShouldCalculateExponent() {
        double base = 4;
        double exponent = 2;
        var exponentNumber = new Exponent(base, exponent);
        Assertions.assertThat(exponentNumber.evaluate()).isEqualTo(16d);
    }
}
