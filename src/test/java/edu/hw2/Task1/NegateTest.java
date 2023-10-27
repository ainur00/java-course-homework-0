package edu.hw2.Task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NegateTest {
    @Test
    void giveNumberShouldNegateIt() {
        double number = 1;
        var negateNumber = new Negate(number);
        Assertions.assertThat(negateNumber.evaluate()).isEqualTo(-1d);
    }
}
