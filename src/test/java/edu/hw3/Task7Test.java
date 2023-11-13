package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;

class Task7Test {
    @Test
    void giveNullStringToTreeMapShouldWork() {
        Task7 task7 = new Task7();
        TreeMap<String, String> tree = new TreeMap<String, String>(task7.nullStringComparator);
        tree.put(null, "test");
        Assertions.assertThat(tree.containsKey(null)).isTrue();
    }
}
