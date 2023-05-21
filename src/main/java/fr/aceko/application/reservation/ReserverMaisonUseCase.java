package fr.aceko.application.reservation;

import fr.aceko.application.BasicUseCaseResponse;
import fr.aceko.domain.*;

public class ReserverMaisonUseCase {
    private final MaisonDao maisonDao;
    private final ClientDao clientDao;

    public ReserverMaisonUseCase(MaisonDao maisonDao, ClientDao clientDao) {
        this.maisonDao = maisonDao;
        this.clientDao = clientDao;
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
