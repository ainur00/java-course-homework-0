package edu.hw5.Task3;

import java.time.LocalDate;

public abstract class DateParser {
    public DateParser(DateParser nextDateParser) {
        this.nextDateParser = nextDateParser;
    }

    public DateParser nextDateParser;

    public abstract LocalDate getParsed(String dateString);
}
