package fr.aceko.infrastructure;

import fr.aceko.domain.Client;
import fr.aceko.domain.ClientDao;
import org.springframework.stereotype.Component;

@Component
public class InMemoryClientDao implements ClientDao {

    @Override
    public Client findById(Long clientId) {
        return InMemoryDataBase.getInstance().clientCollection.get(clientId);
    }
}
