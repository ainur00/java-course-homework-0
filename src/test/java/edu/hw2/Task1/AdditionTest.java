package edu.hw2.Task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AdditionTest {
    @Test
    void giveNumbersShouldCalculateAddition() {
        double summand1 = 4;
        double summand2 = 2;
        var additionNumber = new Addition(summand1, summand2);
        Assertions.assertThat(additionNumber.evaluate()).isEqualTo(6d);
    }
}
