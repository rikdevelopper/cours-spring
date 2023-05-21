package fr.aceko.application;


import fr.aceko.application.maison.ListeMaisonUseCase;
import fr.aceko.domain.Maison;
import fr.aceko.infrastructure.MaisonDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListeMaisonUseCaseTest {

    private final MaisonDao maisonDao = new MaisonDao();
    @AfterEach
    void tearDown(){
        maisonDao.clear();
    }

    @Test
    void listMaison() {

        int sizeBeforeCreate = maisonDao.count();
        Maison maison1 =new Maison("Maison1", 2000, "ADRESSE");
        Maison maison2 =new Maison("Maison2", 2000, "ADRESSE");
        maisonDao.createMaison(maison1);
        maisonDao.createMaison(maison2);

        ListeMaisonUseCase listeMaisonUseCase = new ListeMaisonUseCase();
        assertEquals(sizeBeforeCreate + 2, listeMaisonUseCase.listMaison().size());
    }
}