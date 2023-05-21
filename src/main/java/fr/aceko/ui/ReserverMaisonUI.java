package fr.aceko.ui;

import fr.aceko.application.BasicUseCaseResponse;
import fr.aceko.application.maison.ListeMaisonUseCase;
import fr.aceko.application.reservation.ReserverMaisonRequest;
import fr.aceko.application.reservation.ReserverMaisonUseCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReserverMaisonUI {

    private final ListeMaisonUseCase listeMaisonUseCase;
    private final ReserverMaisonUseCase reserverMaisonUseCase;
    private final Scanner scanner;
    private final ReservationViewModel viewModel;

    public ReserverMaisonUI(ListeMaisonUseCase listeMaisonUseCase, ReserverMaisonUseCase reserverMaisonUseCase) {
        this.scanner = new Scanner(System.in);
        this.listeMaisonUseCase = listeMaisonUseCase;
        this.reserverMaisonUseCase = reserverMaisonUseCase;
        this.viewModel = new ReservationViewModel();
    }

    public void afficherFormulaireReservation() {
        System.out.println("***********Formulaire de réservation d'une maison*********");

        System.out.println("ID: 1, Client: Kossi AHIALEY");
        System.out.println("ID: 2, Client: Eric AHIALEY");
        System.out.print("ID du client sélectionné: ");
        viewModel.clientId = scanner.nextLong();
        listeMaisonUseCase.listMaison().forEach(
                maison -> System.out.println("ID: " + maison.getId() + ", Nom maison: " + maison.getNom())
        );
        System.out.print("ID de la maison sélectionnée: ");
        viewModel.maisonId = scanner.nextLong();

        System.out.print("Loyer à payer: ");
        viewModel.monthlyCost = scanner.nextInt();

        System.out.print("Garantie à déposer: ");
        viewModel.deposit = scanner.nextInt();

        System.out.print("Date de départ (JJ/MM/AAAA): ");
        viewModel.startDate = LocalDate.from(DateTimeFormatter.ofPattern("dd/MM/yyyy").parse(scanner.next()));

        System.out.print("Date de fin (JJ/MM/AAAA): ");
        viewModel.endDate = LocalDate.from(DateTimeFormatter.ofPattern("dd/MM/yyyy").parse(scanner.next()));

        System.out.println("Reservation de la maison en cours..");
        BasicUseCaseResponse response = this.reserverMaisonUseCase.reserverMaison(new ReserverMaisonRequest(viewModel.clientId, viewModel.maisonId,
                viewModel.monthlyCost, viewModel.deposit, viewModel.startDate, viewModel.endDate));
        if (response.hasSucceed())
            System.out.println("Maison reservée.");
        else
            System.out.println("Une erreur est survenue lors de la reservation de la maison: " + String.join(",", response.getErrorMessages()));
    }


}
