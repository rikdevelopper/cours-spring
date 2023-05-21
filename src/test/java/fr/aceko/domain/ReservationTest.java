package fr.aceko.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ReservationTest {

    private final Maison house = new Maison("Maison A", 10000d, "Adidogome");
    private Client validClient;

    @BeforeEach
    void setup(){
        this.validClient = new Client("Steeve", "LASTNAME");
    }
    @Test
    void whenCreatingReservation_withoutClient_throwException() {
        assertThrows(IllegalArgumentException.class, () -> new Reservation(null, house, LocalDate.now(), LocalDate.now().plusMonths(1), 10000, 10000));
    }

    @Test
    void whenCreatingReservation_withoutStartAndEndDate_throwException(){
        assertThrows(IllegalArgumentException.class, () -> new Reservation(this.validClient, house, null, LocalDate.now(), 10000, 10000));
        assertThrows(IllegalArgumentException.class, () -> new Reservation(this.validClient, house, LocalDate.now(), null, 10000, 10000));
        assertThrows(IllegalArgumentException.class, () -> new Reservation(this.validClient, house, null, null, 10000, 10000));
    }

    @Test
    void whenStartDate_isAfter_endDate_throwException(){
        assertThrows(IllegalArgumentException.class, () -> new Reservation(this.validClient, house, LocalDate.now().plusDays(1), LocalDate.now(), 10000, 10000));
    }

    @Test
    void whenCreatingReservation_withMonthlyCostInferiorOrEqualTo0_throwException(){
        assertThrows(IllegalArgumentException.class, () -> new Reservation(this.validClient, house, LocalDate.now(), LocalDate.now().plusMonths(1), 0, 10000));
        assertThrows(IllegalArgumentException.class, () -> new Reservation(this.validClient, house, LocalDate.now(), LocalDate.now().plusMonths(1), -1000, 10000));
    }

    @Test
    void whenCreatingReservation_withDepositInferiorTo0_throwException(){
        assertThrows(IllegalArgumentException.class, () -> new Reservation(this.validClient, house, LocalDate.now(), LocalDate.now().plusMonths(1), 10000, -10000));
    }

    @Test
    void whenCreatingReservation_withoutHouse_throwException() {
        assertThrows(IllegalArgumentException.class, () -> new Reservation(this.validClient, null, LocalDate.now(), LocalDate.now().plusMonths(1), 10000, 10000));
    }
}