package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    private final static DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    private Duration getSessionDuration(String session) {
        List<String> sessionInfo = Arrays.asList(session.split(" - "));
        return Duration.between(
            LocalDateTime.parse(sessionInfo.get(0), DATE_PATTERN),
            LocalDateTime.parse(sessionInfo.get(1), DATE_PATTERN)
        );
    }

    private String getFormattedDuration(Duration duration) {
        return String.format(
            "%sч %sм",
            duration.toHours(),
            duration.toMinutesPart()
        );
    }

    public String getAverageGameSessionTime(List<String> sessions) {
        Duration gameSessionSummaryDuration = Duration.ZERO;
        for (String session : sessions) {
            gameSessionSummaryDuration = gameSessionSummaryDuration.plus(getSessionDuration(session));
        }
        Duration averageGameSessionTime = gameSessionSummaryDuration.dividedBy(sessions.size());
        return getFormattedDuration(averageGameSessionTime);
    }
}
