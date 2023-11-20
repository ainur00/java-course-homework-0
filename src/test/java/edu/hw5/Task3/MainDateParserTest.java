package edu.hw5.Task3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import java.time.LocalDate;
import java.util.Optional;

class MainDateParserTest {
    MainDateParser mainDateParser;

    @BeforeEach
    void setUp() {
        mainDateParser = new MainDateParser();
    }

    static private Arguments[] getDatesAndAnswers() {
        return new Arguments[] {
            Arguments.of (
                "2020-10-10",
                Optional.of(LocalDate.of(2020, 10, 10))
            ),
            Arguments.of (
                "2020-12-2",
                Optional.of(LocalDate.of(2020, 12, 2))
            ),
            Arguments.of (
                "1/3/1976",
                Optional.of(LocalDate.of(1976, 3, 1))
            ),
            Arguments.of (
                "1/3/20",
                Optional.of(LocalDate.of(2020, 3, 1))
            ),
            Arguments.of (
                "tomorrow",
                Optional.of(LocalDate.now().plusDays(1))
            ),
            Arguments.of (
                "today",
                Optional.of(LocalDate.now())
            ),
            Arguments.of (
                "yesterday",
                Optional.of(LocalDate.now().minusDays(1))
            ),
            Arguments.of (
                "1 day ago",
                Optional.of(LocalDate.now().minusDays(1))
            ),
            Arguments.of (
                "2234 days ago",
                Optional.of(LocalDate.now().minusDays(2234))
            ),
            Arguments.of (
                "not a date",
                Optional.empty()
            )
        };
    }

    @ParameterizedTest
    @MethodSource("getDatesAndAnswers")
    void giveNotNullDateStringsShouldReturnOptionalLocalDate(String dateString, Optional<LocalDate> correctLocalDateOptional) {
        Optional<LocalDate> localDateOptional = mainDateParser.getParsed(dateString);
        Assertions.assertThat(localDateOptional).isEqualTo(correctLocalDateOptional);
    }

    @ParameterizedTest
    @EmptySource
    void giveEmptyDateShouldReturnEmptyOptional(String dateString) {
        Optional<LocalDate> localDateOptional = mainDateParser.getParsed(dateString);
        Assertions.assertThat(localDateOptional).isEqualTo(Optional.empty());
    }

    @ParameterizedTest
    @NullSource
    void giveNullDateShouldReturnEmptyOptional(String dateString) {
        Optional<LocalDate> localDateOptional = mainDateParser.getParsed(dateString);
        Assertions.assertThat(localDateOptional).isEqualTo(Optional.empty());
    }
}
