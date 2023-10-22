package edu.hw2.Task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExprTest {
    @ParameterizedTest
    @CsvSource({
        "5, 7, 2, 4, 32",
        "8, 5, 5, 3, -375",
        "-3, -1, 7, 2, 98"
    })
    void giveNumbersAndExpressionShouldCalculateIt(double x0, double x1, double x2, double x3, double res) {
        var result = new Multiplication(new Addition(new Negate(x0), new Constant(x1)), new Exponent(x2, new Constant(x3)));
        Assertions.assertThat(result.evaluate()).isEqualTo(res);
    }
}
