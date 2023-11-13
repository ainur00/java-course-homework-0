package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DistantDaysDateParser extends DateParser {
    public DistantDaysDateParser(DateParser nextDateParser) {
        super(nextDateParser);
    }

    private final static Pattern DISTANT_DAYS_PATTERN = Pattern.compile("^(\\d+)\\sday\\w?\\s(\\w{3,5})$");

    @Override
    public LocalDate getParsed(String dateString) {
        Matcher dateStringMatch = DISTANT_DAYS_PATTERN.matcher(dateString);
        if (dateStringMatch.matches()) {
            LocalDate today = LocalDate.now();
            return switch (dateStringMatch.group(2)) {
                case "ago" -> today.minusDays(Long.parseLong(dateStringMatch.group(1)));
                case "later" -> today.plusDays(Long.parseLong(dateStringMatch.group(1)));
                default -> null;
            };
        }
        return nextDateParser.getParsed(dateString);
    }
}
