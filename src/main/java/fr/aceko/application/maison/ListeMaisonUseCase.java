package fr.aceko.application.maison;

import fr.aceko.domain.Maison;
import fr.aceko.infrastructure.MaisonDao;

import java.util.Set;

public class ListeMaisonUseCase {
    private final MaisonDao maisonDao;
    public ListeMaisonUseCase() {
        this.maisonDao = new MaisonDao();
    }

    public Set<Maison> listMaison() {
        return maisonDao.listAll();
    }
}
