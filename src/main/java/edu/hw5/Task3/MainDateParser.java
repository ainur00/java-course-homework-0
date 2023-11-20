package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class MainDateParser {
    private DateParser getParsersChain() {
        DateParser nullDateParser = new NullDateParser();
        DateParser distantDaysDateParser = new DistantDaysDateParser(nullDateParser);
        DateParser nerbyDaysDateParser = new NerbyDaysDateParser(distantDaysDateParser);
        DateParser dayMonthYearDateParser = new DayMonthYearDateParser(nerbyDaysDateParser);
        return new YearMonthDayDateParser(dayMonthYearDateParser);
    }

    Optional<LocalDate> getParsed(String dateString) {
        if (dateString == null) {
            return Optional.empty();
        }
        LocalDate parsedLocalDate = getParsersChain().getParsed(dateString);
        if (parsedLocalDate != null) {
            return Optional.of(parsedLocalDate);
        }
        return Optional.empty();
    }
}
