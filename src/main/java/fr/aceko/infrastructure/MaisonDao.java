package fr.aceko.infrastructure;

import fr.aceko.domain.Maison;

import java.util.HashSet;
import java.util.Set;

public class MaisonDao {

    public void createMaison(Maison maison) {
        InMemoryDataBase.getInstance().maisonCollection.put(maison.getId(), maison);
    }

    public int count() {
        return InMemoryDataBase.getInstance().maisonCollection.size();
    }

    public boolean exists(String nom) {
        return InMemoryDataBase.getInstance().maisonCollection.values().stream().anyMatch(maison -> maison.getNom().equals(nom));
    }

    public void clear() {
        InMemoryDataBase.getInstance().maisonCollection.clear();
    }

    public Set<Maison> listAll() {
        return new HashSet<>(InMemoryDataBase.getInstance().maisonCollection.values());
    }


    public Maison findById(Long maisonId) {
        return InMemoryDataBase.getInstance().maisonCollection.get(maisonId);
    }
}
