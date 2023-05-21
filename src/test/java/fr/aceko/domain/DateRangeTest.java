package fr.aceko.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateRangeTest {

    @Test
    void test_date_range() {
        LocalDate january1 = LocalDate.of(2023, 1, 1);
        LocalDate january15 = LocalDate.of(2023, 1, 15);
        LocalDate january13 = LocalDate.of(2023, 1, 13);
        LocalDate january20 = LocalDate.of(2023, 1, 20);
        assertTrue(() -> DateRange.of(january1, january15).intersectWith(DateRange.of(january13, january20)));
        assertTrue(() -> DateRange.of(january13, january20).intersectWith(DateRange.of(january1, january15)));
        assertTrue(() -> DateRange.of(january13, january15).intersectWith(DateRange.of(january1, january20)));
        assertTrue(() -> DateRange.of(january1, january20).intersectWith(DateRange.of(january13, january15)));
        assertTrue(() -> DateRange.of(january1, january20).intersectWith(DateRange.of(january1, january15)));
        assertTrue(() -> DateRange.of(january1, january13).intersectWith(DateRange.of(january13, january15)));
        assertFalse(() -> DateRange.of(january1, january13).intersectWith(DateRange.of(january15, january20)));
    }
}