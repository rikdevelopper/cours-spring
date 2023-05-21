package fr.aceko;

import fr.aceko.ui.CreerMaisonUI;
import fr.aceko.ui.ReserverMaisonUI;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "*********************ACEKO location de maisons*******************" );
        int choix = -1;
        while (choix != 0){
            System.out.println( "Pour créer une maison entrez 1" );
            System.out.println( "Pour reserver une maison entrez 2" );
            System.out.println( "Pour quitter l'application entrez 0" );
            choix = scanner.nextInt();
            if(choix == 1) new CreerMaisonUI().afficherCreerMaison();
            if(choix == 2) new ReserverMaisonUI().afficherFormulaireReservation();
        }
    }
}
