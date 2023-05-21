package fr.aceko.infrastructure;

import fr.aceko.domain.Client;

public class ClientDao {

    public Client findById(Long clientId) {
        return InMemoryDataBase.getInstance().clientCollection.get(clientId);
    }
}
