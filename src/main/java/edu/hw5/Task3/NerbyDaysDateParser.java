package edu.hw5.Task3;

import java.time.LocalDate;

public class NerbyDaysDateParser extends DateParser {
    public NerbyDaysDateParser(DateParser nextDateParser) {
        super(nextDateParser);
    }

    private final static String YESTERDAY = "yesterday";

    private final static String TODAY = "today";

    private final static String TOMORROW = "tomorrow";

    private Boolean canParse(String dateString) {
        return dateString.equals(YESTERDAY) || dateString.equals(TODAY) || dateString.equals(TOMORROW);
    }

    @Override
    public LocalDate getParsed(String dateString) {
        if (canParse(dateString)) {
            return switch (dateString) {
                case YESTERDAY -> LocalDate.now().minusDays(1);
                case TODAY -> LocalDate.now();
                case TOMORROW -> LocalDate.now().plusDays(1);
                default -> null;
            };
        }
        return nextDateParser.getParsed(dateString);
    }
}
