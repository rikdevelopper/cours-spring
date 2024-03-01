package fr.aceko.ui;

import fr.aceko.application.maison.CreerMaisonRequest;
import fr.aceko.application.maison.CreerMaisonUseCase;
import fr.aceko.application.maison.MaisonAlreadyExistException;

import java.util.Scanner;

public class CreerMaisonUI {

    private final Scanner scanner;
    private final MaisonViewModel viewModel;
    private final CreerMaisonUseCase creerMaisonUseCase;
    public CreerMaisonUI(CreerMaisonUseCase creerMaisonUseCase) {
        this.scanner =  new Scanner(System.in);
        this.viewModel = new MaisonViewModel();
        this.creerMaisonUseCase = creerMaisonUseCase;
    }

    public void afficherCreerMaison() {
        System.out.println("***********Formulaire de création d'une maison*********");
        System.out.print("Nom de la maison: ");
        viewModel.nom = scanner.nextLine();

        System.out.print("Loyer de la maison: ");
        viewModel.prix = scanner.nextDouble();

        System.out.print("Adresse de la maison: ");
        viewModel.adresse = scanner.next();
        System.out.print("Enregistrement de la maison en cours..");
        try {
            this.creerMaisonUseCase.creerMaison(CreerMaisonRequest.createMinimalRequest(viewModel.nom, viewModel.prix, viewModel.adresse));
            System.out.println("Maison enregistrée.");
        } catch (MaisonAlreadyExistException e) {
            System.out.println("Une erreur est survenue lors de l'enregistrement de la maison: " + e.getMessage());
        }
    }
}
