package fr.aceko.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Client extends Person {
    private String idNumber;
    private String phoneNumber;
    private final Set<Reservation> bookings;

    public Client(String firstName, String lastName) {
        super(firstName, lastName);
        bookings = new HashSet<>();
    }

    public Reservation book(Maison house, LocalDate startDate, LocalDate endDate, int monthlyCost, int deposit) throws UnavailableHouseException {
        Reservation reservation = new Reservation(this, house, startDate, endDate, monthlyCost, deposit);
        this.bookings.add(reservation);
        return reservation;
    }

    public Set<Reservation> getBookings() {
        return Set.copyOf(bookings);
    }
}
