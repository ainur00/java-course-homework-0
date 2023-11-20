package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task6Test {
    Task6 task6;

    @BeforeEach
    void setUp() {
        task6 = new Task6();
    }

    static private Arguments[] getStringsAndAnswers() {
        return new Arguments[] {
            Arguments.of("abc", "achfdbaabgabcaabg", true),
            Arguments.of("ac", "jkasfakbubsxuibe", false),
            Arguments.of("ac", "jkasfakbuacxuibe", true),
            Arguments.of("ac", "acasfakbuacxuibe", true),
            Arguments.of("ac", "unewxybtewvxac", true),
            Arguments.of("ac", "unewxybactewvxac", true),
        };
    }

    @ParameterizedTest
    @MethodSource("getStringsAndAnswers")
    void giveStringsShouldReturnIsSubsequence(String line, String text, Boolean correctAnswer) {
        boolean answer = task6.isSubsequence(line, text);
        Assertions.assertThat(answer).isEqualTo(correctAnswer);
    }

    static private Arguments[] getTwoEmptyStrings() {
        return new Arguments[] {
            Arguments.of("", ""),
        };
    }

    @ParameterizedTest
    @MethodSource("getTwoEmptyStrings")
    void giveEmptyLinesShouldReturnTrue(String line, String text) {
        boolean answer = task6.isSubsequence(line, text);
        Assertions.assertThat(answer).isEqualTo(true);
    }

    static private Arguments[] getTwoNulls() {
        return new Arguments[] {
            Arguments.of(null, null),
        };
    }

    @ParameterizedTest
    @MethodSource("getTwoNulls")
    void giveNullLinesShouldReturnFalse(String line, String text) {
        boolean answer = task6.isSubsequence(line, text);
        Assertions.assertThat(answer).isEqualTo(false);
    }
}
