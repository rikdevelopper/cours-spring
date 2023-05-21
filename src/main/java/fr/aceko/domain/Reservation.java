package fr.aceko.domain;

import java.time.LocalDate;

public class Reservation {

    private static Long ID_COUNT = 1L;
    private final Long id;
    private Client client;
    private LocalDate startDate;
    private LocalDate endDate;
    private int monthlyCost;
    private double deposit;
    private Maison house;

    public Reservation(Client client, Maison house, LocalDate startDate, LocalDate endDate, int monthlyCost, double deposit) throws UnavailableHouseException {
        this.id = ID_COUNT++;
        setStartDate(startDate);
        setEndDate(endDate);
        setHouse(house);
        setClient(client);
        this.setMonthlyCost(monthlyCost);
        this.setDeposit(deposit);
        checkDateValidity(startDate, endDate);
        house.addBooking(this);
    }

    private static void checkDateValidity(LocalDate startDate, LocalDate endDate) {
        if (!startDate.isBefore(endDate))
            throw new IllegalArgumentException("Can not create reservation with invalid dates.");
    }


    protected void setClient(Client client) {
        if (client == null) throw new IllegalArgumentException("Can not create a reservation without Client.");
        this.client = client;
    }

    protected void setStartDate(LocalDate startDate) {
        if (startDate == null) throw new IllegalArgumentException("Can not create a reservation without start date.");
        this.startDate = startDate;
    }

    protected void setEndDate(LocalDate endDate) {
        if (endDate == null) throw new IllegalArgumentException("Can not create a reservation without end date.");
        this.endDate = endDate;
    }

    protected void setMonthlyCost(int monthlyCost) {
        if (monthlyCost <= 0)
            throw new IllegalArgumentException("Can not create a reservation with a monthly cost inferior or equal to zero.");
        this.monthlyCost = monthlyCost;
    }

    protected void setDeposit(double deposit) {
        if (deposit < 0)
            throw new IllegalArgumentException("Can not create a reservation with a deposit inferior to zero.");
        this.deposit = deposit;
    }

    protected void setHouse(Maison house) {
        if (house == null) throw new IllegalArgumentException("The house can not be null.");
        if(this.house != null) throw new IllegalArgumentException("The house can not be changed.");
        this.house = house;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getId() {
        return id;
    }
}
