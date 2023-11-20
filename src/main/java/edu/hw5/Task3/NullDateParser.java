package edu.hw5.Task3;

import java.time.LocalDate;

public class NullDateParser extends DateParser {
    public NullDateParser() {
        super(null);
    }

    @Override
    public LocalDate getParsed(String dateString) {
        return null;
    }
}
