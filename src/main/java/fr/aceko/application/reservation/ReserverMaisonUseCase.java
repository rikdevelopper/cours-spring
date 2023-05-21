package fr.aceko.application.reservation;

import fr.aceko.application.BasicUseCaseResponse;
import fr.aceko.domain.Client;
import fr.aceko.domain.Maison;
import fr.aceko.domain.UnavailableHouseException;
import fr.aceko.infrastructure.ClientDao;
import fr.aceko.infrastructure.MaisonDao;

public class ReserverMaisonUseCase {
    private final MaisonDao maisonDao;
    private final ClientDao clientDao;

    public ReserverMaisonUseCase() {
        this.maisonDao = new MaisonDao();
        this.clientDao = new ClientDao();
    }

    public BasicUseCaseResponse reserverMaison(ReserverMaisonRequest request) {
        Client client = this.clientDao.findById(request.clientId);
        Maison house = this.maisonDao.findById(request.houseId);
        BasicUseCaseResponse response = new BasicUseCaseResponse();
        try {
            client.book(house, request.startDate, request.endDate, request.monthlyCost, request.deposit);
        } catch (UnavailableHouseException e) {
            response.addErrorMessage(e.getMessage());
        }
        return response;
    }
}
