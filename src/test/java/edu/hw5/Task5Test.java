package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class Task5Test {
    Task5 task5;

    @BeforeEach
    void setUp() {
        task5 = new Task5();
    }

    static private Arguments[] getLinesAndAnswers() {
        return new Arguments[] {
            Arguments.of("А123ВЕ777", true),
            Arguments.of("О777ОО177", true),
            Arguments.of("123АВЕ777", false),
            Arguments.of("А123ВГ77", false),
            Arguments.of("А123ВЕ7777", false),
        };
    }

    @ParameterizedTest
    @MethodSource("getLinesAndAnswers")
    void giveLineShouldReturnIsRussianLicensePlate(String line, Boolean correctAnswer) {
        boolean answer = task5.isRussianLicensePlate(line);
        Assertions.assertThat(answer).isEqualTo(correctAnswer);
    }

    @ParameterizedTest
    @EmptySource
    void giveEmptyStringShouldReturnFalse(String line) {
        boolean answer = task5.isRussianLicensePlate(line);
        Assertions.assertThat(answer).isEqualTo(false);
    }

    @ParameterizedTest
    @NullSource
    void giveNullStringShouldReturnFalse(String line) {
        boolean answer = task5.isRussianLicensePlate(line);
        Assertions.assertThat(answer).isEqualTo(false);
    }
}
