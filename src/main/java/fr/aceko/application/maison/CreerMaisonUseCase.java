package fr.aceko.application.maison;


import fr.aceko.domain.Maison;
import fr.aceko.domain.MaisonDao;

public class CreerMaisonUseCase {

    private final MaisonDao maisonDao;

    public CreerMaisonUseCase(MaisonDao maisonDao) {
        this.maisonDao = maisonDao;
    }


    public boolean creerMaison(CreerMaisonRequest request) throws MaisonAlreadyExistException {
        if (this.maisonDao.exists(request.getNom()))
            throw new MaisonAlreadyExistException("Une maison du même nom existe déjà.");
        Maison maison = new Maison(request.getNom(), request.getPrix(), request.getAdresse());
        maison.setCaution(request.getCaution());
        maison.setDescription(request.getDescription());
        maison.setCapaciteGarage(request.getCapaciteGarage());
        maison.setContactHote(request.getContactHote());
        maison.setNbDouche(request.getNbDouche());
        maison.setNbVoyageurs(request.getNbVoyageurs());
        maison.setNbChambre(request.getNbChambre());
        this.maisonDao.createMaison(maison);
        return true;
    }
}
