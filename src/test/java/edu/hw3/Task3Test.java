package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Task3Test {
    private Task3 task3;

    @BeforeEach
    void setUp() {
        task3 = new Task3();
    }

    static private Arguments[] getObjects() {
        return new Arguments[] {
            Arguments.of(
                new ArrayList<Object>(Arrays.asList("a", "bb", "a", "bb")),
                new HashMap<Object, Long>() {{
                    put("a", 2L);
                    put("bb", 2L);
                }}
            ),
            Arguments.of(
                new ArrayList<Object>(Arrays.asList("this", "and", "that", "and")),
                new HashMap<Object, Long>() {{
                    put("this", 1L);
                    put("that", 1L);
                    put("and", 2L);
                }}
            ),
            Arguments.of(
                new ArrayList<Object>(Arrays.asList("код", "код", "код", "bug")),
                new HashMap<Object, Long>() {{
                    put("код", 3L);
                    put("bug", 1L);
                }}
            ),
            Arguments.of(
                new ArrayList<Object>(Arrays.asList(1, 1, 2, 2)),
                new HashMap<Object, Long>() {{
                    put(1, 2L);
                    put(2, 2L);
                }}
            )
        };
    }
    @ParameterizedTest
    @MethodSource("getObjects")
    void giveObjectsShouldReturnFrequencyDictionary(ArrayList<Object> objects, HashMap<Object, Long> frequencyDictionary) {
        HashMap<Object, Long> calculatedFrequencyDictionary = task3.getFrequencyDictionary(objects);
        Assertions.assertThat(calculatedFrequencyDictionary).isEqualTo(frequencyDictionary);
    }

    @ParameterizedTest
    @EmptySource
    void giveEmptyListShouldReturnEmptyFrequencyDictionary(ArrayList<Object> objects) {
        HashMap<Object, Long> calculatedFrequencyDictionary = task3.getFrequencyDictionary(objects);
        Assertions.assertThat(calculatedFrequencyDictionary).isEmpty();
    }
}
