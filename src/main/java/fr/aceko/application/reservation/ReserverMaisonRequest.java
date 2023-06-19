package fr.aceko.application.reservation;

import java.time.LocalDate;

public class ReserverMaisonRequest {
    public final Long clientId;
    public final Long houseId;
    public final int monthlyCost;
    public final int deposit;
    public final LocalDate startDate;
    public final LocalDate endDate;

    public ReserverMaisonRequest(Long clientId, Long houseId, int monthlyCost, int deposit, LocalDate startDate, LocalDate endDate) {
        this.clientId = clientId;
        this.houseId = houseId;
        this.monthlyCost = monthlyCost;
        this.deposit = deposit;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
