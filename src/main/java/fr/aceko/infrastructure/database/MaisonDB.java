package fr.aceko.infrastructure.database;

public class MaisonDB {
    public final Long id;
    public final String nom;
    public final double prix;
    public final String adresse;

    public MaisonDB(Long id, String nom, double prix, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.adresse = adresse;
    }
}
