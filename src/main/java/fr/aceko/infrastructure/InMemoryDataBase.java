package fr.aceko.infrastructure;

import fr.aceko.domain.Client;
import fr.aceko.domain.Maison;
import fr.aceko.domain.Reservation;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDataBase {

    private static final InMemoryDataBase INSTANCE = new InMemoryDataBase();
    public final Map<Long, Client> clientCollection = new HashMap<>();
    public final Map<Long, Maison> maisonCollection = new HashMap<>();
    public final Map<Long, Reservation> reservationCollection = new HashMap<>();

    public static InMemoryDataBase getInstance() {
        return INSTANCE;
    }

    public InMemoryDataBase() {
        this.initClientData();
        this.initMaisonData();
    }

    private void initClientData() {
        Client kossi = new Client("Kossi", "AHIALEY");
        Client eric = new Client("Eric", "AHIALEY");
        clientCollection.put(kossi.getId(), kossi);
        clientCollection.put(eric.getId(), eric);
    }

    private void initMaisonData() {
        Maison maison1 = new Maison("Maison 1", 1000, "Adresse 1");
        Maison maison2 = new Maison("Maison 2", 500, "Adresse 2");
        maisonCollection.put(maison1.getId(), maison1);
        maisonCollection.put(maison2.getId(), maison2);
    }

}
