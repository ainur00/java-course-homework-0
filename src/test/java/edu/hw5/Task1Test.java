package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;

class Task1Test {
    static private Arguments[] getSessionsLists() {
        return new Arguments[] {
            Arguments.of(
                List.of(
                    "2022-03-12, 20:20 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20"
                ),
                "3ч 40м"
            ),
            Arguments.of(
                List.of(
                    "2022-03-12, 20:20 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20",
                    "2022-04-03, 01:00 - 2022-04-04, 01:20",
                    "2022-04-08, 15:00 - 2022-04-08, 16:00"
                ),
                "8ч 10м"
            )
        };
    }

    @ParameterizedTest
    @MethodSource("getSessionsLists")
    void giveSessionsListsShouldReturnAverageGameSessionTime(List<String> sessions, String correctAverageGameSessionTime) {
        Task1 task1 = new Task1();
        String averageGameSessionTime = task1.getAverageGameSessionTime(sessions);
        Assertions.assertThat(averageGameSessionTime).isEqualTo(correctAverageGameSessionTime);
    }
}
