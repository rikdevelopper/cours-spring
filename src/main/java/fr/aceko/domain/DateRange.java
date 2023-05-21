package fr.aceko.domain;

import java.time.LocalDate;

public class DateRange {
    private final LocalDate start;
    private final LocalDate end;

    public DateRange(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public static DateRange of(LocalDate start, LocalDate end) {
        return new DateRange(start, end);
    }


    public boolean intersectWith(DateRange dateRange){
        return between(start, dateRange) || between(end, dateRange) || between(dateRange.start, this);
    }

    private boolean between(LocalDate date, DateRange dateRange){
        return !isNotBetween(date, dateRange);
    }
    private boolean isNotBetween(LocalDate date, DateRange dateRange){
        return date.isBefore(dateRange.start) || date.isAfter(dateRange.end);
    }

}
