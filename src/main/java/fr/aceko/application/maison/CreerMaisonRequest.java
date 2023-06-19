package fr.aceko.application.maison;

public class CreerMaisonRequest {
    private String nom;
    private double prix;
    private String adresse;
    private String description;
    private String contactHote;
    private Double caution;
    private int nbChambre;
    private int nbDouche;
    private int capaciteGarage;
    private int nbVoyageurs;

    public static CreerMaisonRequest createMinimalRequester(String nom, double prix, String adresse) {
        CreerMaisonRequest requester = new CreerMaisonRequest();
        requester.nom = nom;
        requester.prix = prix;
        requester.adresse = adresse;
        return requester;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDescription() {
        return description;
    }

    public String getContactHote() {
        return contactHote;
    }

    public Double getCaution() {
        return caution;
    }

    public int getNbChambre() {
        return nbChambre;
    }

    public int getNbDouche() {
        return nbDouche;
    }

    public int getCapaciteGarage() {
        return capaciteGarage;
    }

    public int getNbVoyageurs() {
        return nbVoyageurs;
    }
}
