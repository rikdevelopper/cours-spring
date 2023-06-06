package fr.aceko.infrastructure;

import fr.aceko.domain.Maison;
import fr.aceko.domain.MaisonDao;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


public class InMemoryMaisonDao implements MaisonDao {

    @Override
    public void createMaison(Maison maison) {
        InMemoryDataBase.getInstance().maisonCollection.put(maison.getId(), maison);
    }

    @Override
    public int count() {
        return InMemoryDataBase.getInstance().maisonCollection.size();
    }

    @Override
    public boolean exists(String nom) {
        return InMemoryDataBase.getInstance().maisonCollection.values().stream().anyMatch(maison -> maison.getNom().equals(nom));
    }

    @Override
    public void clear() {
        InMemoryDataBase.getInstance().maisonCollection.clear();
    }

    @Override
    public Set<Maison> listAll() {
        return new HashSet<>(InMemoryDataBase.getInstance().maisonCollection.values());
    }


    @Override
    public Maison findById(Long maisonId) {
        return InMemoryDataBase.getInstance().maisonCollection.get(maisonId);
    }
}
