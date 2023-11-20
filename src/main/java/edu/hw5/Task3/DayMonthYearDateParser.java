package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayMonthYearDateParser extends DateParser {
    public DayMonthYearDateParser(DateParser nextDateParser) {
        super(nextDateParser);
    }

    private final static Pattern DAY_MONTH_YEAR_PATTERN = Pattern.compile("^(\\d{1,2})/(\\d{1,2})/(\\d{2,4})$");

    private final static Byte DAY_GROUP = 1;

    private final static Byte MONTH_GROUP = 2;

    private final static Byte YEAR_GROUP = 3;

    @Override
    public LocalDate getParsed(String dateString) {
        Matcher dateStringMatch = DAY_MONTH_YEAR_PATTERN.matcher(dateString);
        if (dateStringMatch.matches()) {
            return LocalDate.of(
                Integer.parseInt(
                    dateStringMatch.group(YEAR_GROUP).length() == 2
                        ? "20" + dateStringMatch.group(YEAR_GROUP) : dateStringMatch.group(YEAR_GROUP)
                ),
                Integer.parseInt(dateStringMatch.group(MONTH_GROUP)),
                Integer.parseInt(dateStringMatch.group(DAY_GROUP))
            );
        }
        return nextDateParser.getParsed(dateString);
    }
}
