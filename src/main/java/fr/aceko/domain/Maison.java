package fr.aceko.domain;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class Maison {

    private static Long ID_COUNT = 1L;
    private final Long id;
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
    private Set<Reservation> bookings;

    public Maison(String nom, double prix, String adresse) {
        if (nom == null || nom.isBlank()) throw new IllegalArgumentException("Le nom ne peut être Null ou vide.");
        this.nom = nom;
        if (prix < 0) throw new IllegalArgumentException("Le prix ne peut être négatif.");
        this.prix = prix;
        if (adresse == null || adresse.isBlank())
            throw new IllegalArgumentException("L'adresse ne peut être Null ou vide.");
        this.adresse = adresse;
        bookings = new HashSet<>();
        this.id = ID_COUNT++;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactHote(String contactHote) {
        this.contactHote = contactHote;
    }

    public void setCaution(Double caution) {
        this.caution = caution;
    }

    public void setNbChambre(int nbChambre) {
        this.nbChambre = nbChambre;
    }

    public void setNbDouche(int nbDouche) {
        this.nbDouche = nbDouche;
    }

    public void setCapaciteGarage(int capaciteGarage) {
        this.capaciteGarage = capaciteGarage;
    }

    public void setNbVoyageurs(int nbVoyageurs) {
        this.nbVoyageurs = nbVoyageurs;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maison maison = (Maison) o;
        return Objects.equals(nom, maison.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    public boolean isAvailableBetween(LocalDate startDate, LocalDate endDate) {
        DateRange period = DateRange.of(startDate, endDate);
        Predicate<Reservation> hasBookingForPeriod = reservation -> period.intersectWith(DateRange.of(reservation.getStartDate(), reservation.getEndDate()));
        return this.bookings.stream()
                .noneMatch(hasBookingForPeriod);
    }

    public Set<Reservation> getBookings() {
        return Set.copyOf(bookings);
    }

    public void addBooking(Reservation reservation) throws UnavailableHouseException {
        if (this.isAvailableBetween(reservation.getStartDate(), reservation.getEndDate()))
            this.bookings.add(reservation);
        else throw new UnavailableHouseException("The house is not available for the selected period.");
    }

    public Long getId() {
        return id;
    }
}
