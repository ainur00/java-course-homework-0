package edu.hw2.Task2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RectangleTest {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle(3, 12)),
            Arguments.of(new Square(6)),
            Arguments.of(new Rectangle(9, 4))
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void give36RectanglesAreaShouldEquals36(Rectangle rect) {
        Assertions.assertThat(rect.getArea()).isEqualTo(36.0);
    }
}
