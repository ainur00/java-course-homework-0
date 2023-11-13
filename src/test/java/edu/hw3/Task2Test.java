package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;

class Task2Test {
    private Task2 task2;

    @BeforeEach
    void setUp() {
        task2 = new Task2();
    }

    @ParameterizedTest
    @CsvSource(
        value = {
            "()()():[(), (), ()]",
            "((())):[((()))]",
            "((()))(())()()(()()):[((())), (()), (), (), (()())]",
            "((())())(()(()())):[((())()), (()(()()))]"
        },
        delimiter = ':'
    )
    void giveBracketsSequenceShouldClusterBrackets(String line, String correctEncryptedLine) {
        ArrayList<String> clusteredBrackets = task2.getClusteredBrackets(line);
        Assertions.assertThat(clusteredBrackets.toString()).isEqualTo(correctEncryptedLine);
    }

    @ParameterizedTest
    @ValueSource (strings = {"((((((", ")))))))", ""})
    void giveIncorrectBracketsSequenceShouldReturnEmptyList(String lineWithoutClusters) {
        ArrayList<String> clusteredBrackets = task2.getClusteredBrackets(lineWithoutClusters);
        Assertions.assertThat(clusteredBrackets).isEmpty();
    }
}
