package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class Task4Test {
    Task4 task4;

    @BeforeEach
    void setUp() {
        task4 = new Task4();
    }

    static private Arguments[] getPasswordsAndAnswers() {
        return new Arguments[] {
            Arguments.of("f3~dg4f", true),
            Arguments.of("onO!!buo!c", true),
            Arguments.of("y3@yg6f", true),
            Arguments.of("77Fef#fv", true),
            Arguments.of("93$3h7f", true),
            Arguments.of("nnvu%ssf5", true),
            Arguments.of("sdf^fv3g", true),
            Arguments.of("luhf3&&3f", true),
            Arguments.of("f3wgvr*wb", true),
            Arguments.of("dbsfbdSS|g", true),
            Arguments.of("DdLNGd", false),
        };
    }

    @ParameterizedTest
    @MethodSource("getPasswordsAndAnswers")
    void givePasswordsShouldReturnIsTheyHasSpecialSymbols(String password, Boolean correctAnswer) {
        boolean answer = task4.isPasswordHasSpecialSymbols(password);
        Assertions.assertThat(answer).isEqualTo(correctAnswer);
    }

    @ParameterizedTest
    @EmptySource
    void giveEmptyStringShouldReturnFalse(String password) {
        boolean answer = task4.isPasswordHasSpecialSymbols(password);
        Assertions.assertThat(answer).isEqualTo(false);
    }

    @ParameterizedTest
    @NullSource
    void giveNullStringShouldReturnFalse(String password) {
        boolean answer = task4.isPasswordHasSpecialSymbols(password);
        Assertions.assertThat(answer).isEqualTo(false);
    }
}
