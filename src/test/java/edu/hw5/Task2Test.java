package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;

class Task2Test {
    private Task2 task2;

    @BeforeEach
    void setUp() {
        task2 = new Task2();
    }

    static private Arguments[] getYears() {
        return new Arguments[] {
            Arguments.of(
                2024,
                List.of("2024-09-13", "2024-12-13")
            ),
            Arguments.of(
                1925,
                List.of("1925-02-13", "1925-03-13", "1925-11-13")
            )
        };
    }

    @ParameterizedTest
    @MethodSource("getYears")
    void giveYearShouldReturnAllFridayThirteenInYear(Integer year, List<String> correctListOfAllFridayThirteenInYear) {
        List<String> allFridayThirteenInYear = task2.getAllFridayThirteenInYear(year);
        Assertions.assertThat(allFridayThirteenInYear).isEqualTo(correctListOfAllFridayThirteenInYear);
    }

    @ParameterizedTest
    @CsvSource(
        value = {
            "2024-08-11, 2024-09-13",
            "2024-11-22, 2024-12-13",
            "1924-12-21, 1925-02-13"
        }
    )
    void giveDateShouldReturnNearestFridayThirteen(String currentDate, String correctNearestFridayThirteen) {
        String nearestFridayThirteen = task2.getNearestFridayThirteen(currentDate);
        Assertions.assertThat(nearestFridayThirteen).isEqualTo(correctNearestFridayThirteen);
    }
}
