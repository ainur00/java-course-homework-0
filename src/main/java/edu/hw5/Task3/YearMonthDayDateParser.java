package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YearMonthDayDateParser extends DateParser {
    public YearMonthDayDateParser(DateParser nextDateParser) {
        super(nextDateParser);
    }

    private final static Pattern YEAR_MONTH_DAY_PATTERN = Pattern.compile("^(\\d{4})-(\\d{1,2})-(\\d{1,2})$");

    private final static Byte DAY_GROUP = 3;

    private final static Byte MONTH_GROUP = 2;

    private final static Byte YEAR_GROUP = 1;

    @Override
    public LocalDate getParsed(String dateString) {
        Matcher dateStringMatch = YEAR_MONTH_DAY_PATTERN.matcher(dateString);
        if (dateStringMatch.matches()) {
            return LocalDate.of(
                Integer.parseInt(dateStringMatch.group(YEAR_GROUP)),
                Integer.parseInt(dateStringMatch.group(MONTH_GROUP)),
                Integer.parseInt(dateStringMatch.group(DAY_GROUP))
            );
        }
        return nextDateParser.getParsed(dateString);
    }
}
