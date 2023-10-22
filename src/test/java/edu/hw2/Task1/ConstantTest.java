package edu.hw2.Task1;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class ConstantTest {
    @Test
    void giveNumberShouldMakeConstant() {
        double number = 1;
        var constNumber = new Constant(number);
        Assertions.assertThat(constNumber.evaluate()).isEqualTo(1d);
    }

}
