package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private final static Byte THIRTEEN = 13;

    public List<String> getAllFridayThirteenInYear(Integer year) {
        List<String> allFridayThirteenInYear = new ArrayList<String>();
        LocalDate yearHandler = LocalDate.of(year, 1, 1);
        // check only fridays
        yearHandler = yearHandler.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (yearHandler.getYear() != year + 1) {
            if (yearHandler.getDayOfMonth() == THIRTEEN) {
                allFridayThirteenInYear.add(yearHandler.toString());
            }
            yearHandler = yearHandler.plusWeeks(1);
        }
        return allFridayThirteenInYear;
    }

    public String getNearestFridayThirteen(String date) {
        LocalDate currentDate = LocalDate.parse(date);
        TemporalAdjuster getNearestFridayThirteenTemporalAdjuster = temporal -> {
            Temporal temporalCopy = temporal;
            temporalCopy = temporalCopy.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            while (temporalCopy.get(ChronoField.DAY_OF_MONTH) != THIRTEEN) {
                temporalCopy = temporalCopy.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            }
            return temporalCopy;
        };
        LocalDate nearestFridayThirteen = currentDate.with(getNearestFridayThirteenTemporalAdjuster);
        return nearestFridayThirteen.toString();
    }
}
