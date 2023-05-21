package fr.aceko.infrastructure;

import fr.aceko.domain.Reservation;

public class ReservationDao {

    public Reservation createReservation(Reservation reservation){
        InMemoryDataBase.getInstance().reservationCollection.put(reservation.getId(), reservation);
        return reservation;
    }
}
