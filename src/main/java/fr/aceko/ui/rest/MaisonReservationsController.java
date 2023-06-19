package fr.aceko.ui.rest;

import fr.aceko.application.reservation.ReserverMaisonRequest;
import fr.aceko.application.reservation.ReserverMaisonUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/maisons/{maisonId}/reservations")
@RestController
public class MaisonReservationsController {

    private final ReserverMaisonUseCase reserverMaisonUseCase;

    public MaisonReservationsController(ReserverMaisonUseCase reserverMaisonUseCase) {
        this.reserverMaisonUseCase = reserverMaisonUseCase;
    }

    @PostMapping
    public ResponseEntity bookHouse(@RequestBody ReserverMaisonRequest request, @PathVariable Long maisonId){
        ReserverMaisonRequest ucRequest = new ReserverMaisonRequest(request.clientId, maisonId, request.monthlyCost,
                request.deposit, request.startDate, request.endDate);
        this.reserverMaisonUseCase.reserverMaison(ucRequest);
        return ResponseEntity.ok().build();
    }
}
