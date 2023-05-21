package fr.aceko.application.maison;


import fr.aceko.domain.Maison;
import fr.aceko.infrastructure.MaisonDao;

public class CreerMaisonUseCase {

    private final MaisonDao maisonDao;

    public CreerMaisonUseCase() {
        this.maisonDao = new MaisonDao();
    }


    public boolean creerMaison(CreerMaisonRequester requester) throws MaisonAlreadyExistException {
        if (this.maisonDao.exists(requester.getNom()))
            throw new MaisonAlreadyExistException("Une maison du même nom existe déjà.");
        Maison maison = new Maison(requester.getNom(), requester.getPrix(), requester.getAdresse());
        maison.setCaution(requester.getCaution());
        maison.setDescription(requester.getDescription());
        maison.setCapaciteGarage(requester.getCapaciteGarage());
        maison.setContactHote(requester.getContactHote());
        maison.setNbDouche(requester.getNbDouche());
        maison.setNbVoyageurs(requester.getNbVoyageurs());
        maison.setNbChambre(requester.getNbChambre());
        this.maisonDao.createMaison(maison);
        return true;
    }
}
