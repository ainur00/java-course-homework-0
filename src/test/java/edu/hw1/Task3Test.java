package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task3Test {
    private Task3 task3;

    @BeforeEach
    void setUp() {
        task3 = new Task3();
    }

    @Test
    void giveCanNestedShouldReturnTrue() {
        Long[] nested = new Long[] {1L, 2L, 3L, 4L};
        Long[] accommodating = new Long[] {0L, 6L};
        Boolean response = task3.isNested(nested, accommodating);
        Assertions.assertThat(response).isEqualTo(true);
    }

    @Test
    void giveCannotNestedShouldReturnFalse() {
        Long[] nested = new Long[] {1L, 2L, 3L, 4L};
        Long[] accommodating = new Long[] {3L, 2L};
        Boolean response = task3.isNested(nested, accommodating);
        Assertions.assertThat(response).isEqualTo(false);
    }

    @Test
    void giveEmptyNestedShouldReturnTrue() {
        Long[] nested = new Long[] {};
        Long[] accommodating = new Long[] {0L, 999L};
        Boolean response = task3.isNested(nested, accommodating);
        Assertions.assertThat(response).isEqualTo(true);
    }

    @Test
    void giveNonEmptyNestedAndEmptyAccommodatingShouldReturnFalse() {
        Long[] nested = new Long[] {0L, 999L};
        Long[] accommodating = new Long[] {};
        Boolean response = task3.isNested(nested, accommodating);
        Assertions.assertThat(response).isEqualTo(false);
    }
}
