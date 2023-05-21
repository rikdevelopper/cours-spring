package fr.aceko.application.maison;

import fr.aceko.domain.Maison;
import fr.aceko.domain.MaisonDao;

import java.util.Set;

public class ListeMaisonUseCase {
    private final MaisonDao maisonDao;
    public ListeMaisonUseCase(MaisonDao maisonDao) {
        this.maisonDao = maisonDao;
    }

    public Set<Maison> listMaison() {
        return maisonDao.listAll();
    }
}
