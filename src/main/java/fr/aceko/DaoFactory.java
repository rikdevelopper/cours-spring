package fr.aceko;

import fr.aceko.domain.ClientDao;
import fr.aceko.domain.MaisonDao;
import fr.aceko.infrastructure.InMemoryClientDao;
import fr.aceko.infrastructure.InMemoryMaisonDao;

public class DaoFactory {

    public static MaisonDao maisonDao(){
        return new InMemoryMaisonDao();
    }

    public static ClientDao clientDao(){
        return new InMemoryClientDao();
    }
}
