package fr.aceko.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client validClient;
    private Maison validHouse;

    @BeforeEach
    void setup() {
        this.validClient = new Client("Steeve", "LASTNAME");
        this.validHouse = new Maison("Maison X", 10000d, "Adidogomé");
    }

    @Test
    void whenCreatingClient_withoutFirstName_throwException() {
        assertThrows(IllegalArgumentException.class, () -> new Client("", "LASTNAME"));
        assertThrows(IllegalArgumentException.class, () -> new Client(null, "LASTNAME"));
    }

    @Test
    void whenCreatingClient_withoutLastName_throwException() {
        assertThrows(IllegalArgumentException.class, () -> new Client("Steeve", ""));
        assertThrows(IllegalArgumentException.class, () -> new Client("Steeve", null));
    }

    @Test
    void whenCreatingClient_withLastNameAndFirstName_thenOK() {
        assertDoesNotThrow(() -> new Client("First name", "Last name"));
    }

    @Test
    void whenBookingWithoutHouse_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> this.validClient.book(null, LocalDate.now(), LocalDate.now().plusMonths(1), 10000, 15000));
    }

    @Test
    void whenBookingUnavailableHouse_throwUnavailableHouseException() throws UnavailableHouseException {
        this.validClient.book(validHouse, LocalDate.now(), LocalDate.now().plusMonths(1), 15000, 1000);
        Client karl = new Client("Karl", "Lastname");
        assertThrows(UnavailableHouseException.class, () -> karl.book(validHouse, LocalDate.now(), LocalDate.now().plusMonths(1), 17000, 1000));
        assertThrows(UnavailableHouseException.class, () -> karl.book(validHouse, LocalDate.now().plusDays(3), LocalDate.now().plusMonths(2), 17000, 1000));
    }

    @Test
    void whenBookingAvailableHouse_shouldBeOk() throws UnavailableHouseException {
        LocalDate now = LocalDate.now();
        LocalDate nowPlusOneMonth = now.plusMonths(1);
        LocalDate nowPlusOneMonthPlusOneDay = nowPlusOneMonth.plusDays(1);
        LocalDate futureEndDate = nowPlusOneMonthPlusOneDay.plusMonths(1);
        this.validClient.book(validHouse, now, nowPlusOneMonth, 15000, 1000);
        Client karl = new Client("Karl", "Lastname");
        karl.book(validHouse, nowPlusOneMonthPlusOneDay, futureEndDate, 17000, 1000);
        assertEquals(2, validHouse.getBookings().size());
        assertEquals(1, karl.getBookings().size());
        assertEquals(1, validClient.getBookings().size());
    }
}