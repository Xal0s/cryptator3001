package menu;

import aide.Aide;
import motDePasse.DemandeMotDePasse;

import java.util.Scanner;

public class Menu {

    public static void afficherMenu(String mdp) {
        boolean choix = true;
        while (choix) {

            System.out.println(
                "Voulez-vous :\n" +
                "1 - Entrer un nouveau mot de passe\n"+
                "2 - Chiffrer votre mot de passe \n" +
                "3 - Hacher votre mot de passe\n" +
                "4 - Avoir de l'aide\n" +
                "5 - Quitter\n"
            );
            System.out.println(mdp);

            Scanner scan = new Scanner(System.in);

            switch (scan.nextInt()) {
                case 1:
                    choix = false;
                    DemandeMotDePasse.demandeMotDePasse();
                    break;
                case 2:
                    choix = false;
                    MenuChiffrement.afficherMenuChiffrement(mdp);
                    break;
                case 3:
                    choix = false;
                    MenuHachage.afficherMenuHachage(mdp);
                    break;
                case 4:
                    choix = false;
                    Aide.afficherAide(mdp);
                    break;
                case 5:
                    System.exit(0);
                default: System.out.println("\nVotre choix n'est pas disponible\n");
            }
        }
    }
}
