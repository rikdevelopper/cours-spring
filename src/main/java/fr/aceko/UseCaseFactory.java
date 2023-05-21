package fr.aceko;

import fr.aceko.application.maison.CreerMaisonUseCase;
import fr.aceko.application.maison.ListeMaisonUseCase;
import fr.aceko.application.reservation.ReserverMaisonUseCase;

public class UseCaseFactory {

    public static CreerMaisonUseCase creerMaisonUseCase(){
        return new CreerMaisonUseCase(DaoFactory.maisonDao());
    }
    public static ListeMaisonUseCase listeMaisonUseCase(){
        return new ListeMaisonUseCase(DaoFactory.maisonDao());
    }

    public static ReserverMaisonUseCase reserverMaisonUseCase(){
        return new ReserverMaisonUseCase(DaoFactory.maisonDao(), DaoFactory.clientDao());
    }
}
