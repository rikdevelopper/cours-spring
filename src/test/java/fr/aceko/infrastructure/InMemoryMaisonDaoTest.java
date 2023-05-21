package fr.aceko.infrastructure;


import fr.aceko.domain.Maison;
import fr.aceko.domain.MaisonDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryMaisonDaoTest {

    @Test
    void listAll() {
        MaisonDao maisonDao = new InMemoryMaisonDao();
        Maison maison1 =new Maison("Maison1", 2000, "ADRESSE");
        Maison maison2 =new Maison("Maison2", 2000, "ADRESSE");
        maisonDao.createMaison(maison1);
        maisonDao.createMaison(maison2);
        assertEquals(2, maisonDao.listAll().size());
        maisonDao.clear();
    }
}