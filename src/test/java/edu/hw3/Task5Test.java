package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import java.util.ArrayList;
import java.util.Arrays;

class Task5Test {
    private Task5 task5;

    @BeforeEach
    void setUp() {
        task5 = new Task5();
    }

    static private Arguments[] getContacts() {
        return new Arguments[] {
            Arguments.of(
                new ArrayList<String>(Arrays.asList("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes")),
                true,
                new ArrayList<Object>(Arrays.asList("Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"))
            ),
            Arguments.of(
                new ArrayList<String>(Arrays.asList("Paul Erdos", "Leonhard Euler", "Carl Gauss")),
                false,
                new ArrayList<Object>(Arrays.asList("Carl Gauss", "Leonhard Euler", "Paul Erdos"))
            ),
            Arguments.of(
                new ArrayList<String>(Arrays.asList("Paul", "Leonhard Euler", "Carl")),
                true,
                new ArrayList<Object>(Arrays.asList("Carl", "Leonhard Euler", "Paul"))
            )
        };
    }
    @ParameterizedTest
    @MethodSource("getContacts")
    void giveContactsShouldSortThem(ArrayList<String> contacts, Boolean isASC, ArrayList<Object> properlyParsedContacts) {
        ArrayList<Object> sortedContacts = task5.getParsedContacts(contacts, isASC);
        Assertions.assertThat(sortedContacts).isEqualTo(properlyParsedContacts);
    }

    @ParameterizedTest
    @EmptySource
    void giveEmptyContactsShouldReturnEmptyArrayList(ArrayList<String> contacts) {
        ArrayList<Object> sortedContacts = task5.getParsedContacts(contacts, true);
        Assertions.assertThat(sortedContacts).isEqualTo(new ArrayList<Object>());
    }

    @ParameterizedTest
    @NullSource
    void giveNullContactsShouldReturnEmptyArrayList(ArrayList<String> contacts) {
        ArrayList<Object> sortedContacts = task5.getParsedContacts(contacts, true);
        Assertions.assertThat(sortedContacts).isEqualTo(new ArrayList<Object>());
    }
}
