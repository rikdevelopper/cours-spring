package fr.aceko.domain;

import java.util.Set;

public interface MaisonDao {
    void createMaison(Maison maison);

    int count();

    boolean exists(String nom);

    void clear();

    Set<Maison> listAll();

    Maison findById(Long maisonId);
}
