package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class Task7Test {
    Task7 task7;

    @BeforeEach
    void setUp() {
        task7 = new Task7();
    }

    static private Arguments[] getLinesForHasMinThree01AndThirdIs0() {
        return new Arguments[] {
            Arguments.of("001", false),
            Arguments.of("0001", true),
            Arguments.of("00100", false),
        };
    }

    @ParameterizedTest
    @MethodSource("getLinesForHasMinThree01AndThirdIs0")
    void giveLineShouldReturnHasMinThree01AndThirdIs0(String line, Boolean correctAnswer) {
        boolean answer = task7.hasMinThree01AndThirdIs0(line);
        Assertions.assertThat(answer).isEqualTo(correctAnswer);
    }

    static private Arguments[] getLinesForStartsAndEndsWithSameSymbol() {
        return new Arguments[] {
            Arguments.of("00101010100", true),
            Arguments.of("11010010111101011", true),
            Arguments.of("00100010110101", false),
        };
    }

    @ParameterizedTest
    @MethodSource("getLinesForStartsAndEndsWithSameSymbol")
    void giveLineShouldReturnStartsAndEndsWithSameSymbol(String line, Boolean correctAnswer) {
        boolean answer = task7.startsAndEndsWithSameSymbol(line);
        Assertions.assertThat(answer).isEqualTo(correctAnswer);
    }

    static private Arguments[] getLinesForHasMinOne01AndMaxThree01() {
        return new Arguments[] {
            Arguments.of("00101010100", false),
            Arguments.of("0", true),
            Arguments.of("01", true),
            Arguments.of("011", true),
        };
    }

    @ParameterizedTest
    @MethodSource("getLinesForHasMinOne01AndMaxThree01")
    void giveLineShouldReturnHasMinOne01AndMaxThree01(String line, Boolean correctAnswer) {
        boolean answer = task7.hasMinOne01AndMaxThree01(line);
        Assertions.assertThat(answer).isEqualTo(correctAnswer);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void giveNullAndEmptyLineShouldReturnFalseForHasMinThree01AndThirdIs0(String line) {
        boolean answer = task7.hasMinThree01AndThirdIs0(line);
        Assertions.assertThat(answer).isEqualTo(false);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void giveNullAndEmptyLineShouldReturnFalseForStartsAndEndsWithSameSymbol(String line) {
        boolean answer = task7.startsAndEndsWithSameSymbol(line);
        Assertions.assertThat(answer).isEqualTo(false);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void giveNullAndEmptyLineShouldReturnFalseForHasMinOne01AndMaxThree01(String line) {
        boolean answer = task7.hasMinOne01AndMaxThree01(line);
        Assertions.assertThat(answer).isEqualTo(false);
    }
}
