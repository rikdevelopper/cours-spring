package fr.aceko;

import fr.aceko.ui.CreerMaisonUI;
import fr.aceko.ui.ReserverMaisonUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("*********************ACEKO location de maisons*******************");
        int choix = -1;
        while (choix != 0) {
            System.out.println("Pour créer une maison entrez 1");
            System.out.println("Pour reserver une maison entrez 2");
            System.out.println("Pour quitter l'application entrez 0");
            choix = scanner.nextInt();
            if (choix == 1) context.getBean(CreerMaisonUI.class).afficherCreerMaison();
            if (choix == 2)
                context.getBean(ReserverMaisonUI.class).afficherFormulaireReservation();
        }
    }
}
