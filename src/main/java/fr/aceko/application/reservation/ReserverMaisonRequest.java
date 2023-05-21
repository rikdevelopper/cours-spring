package fr.aceko.application.reservation;

import java.time.LocalDate;

public class ReserverMaisonRequest {
    final Long clientId;
    final Long houseId;
    final int monthlyCost;
    final int deposit;
    final LocalDate startDate;
    final LocalDate endDate;

    public ReserverMaisonRequest(Long clientId, Long houseId, int monthlyCost, int deposit, LocalDate startDate, LocalDate endDate) {
        this.clientId = clientId;
        this.houseId = houseId;
        this.monthlyCost = monthlyCost;
        this.deposit = deposit;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
