package menu;

import aide.Aide;
import java.util.Scanner;
import motDePasse.DemandeMotDePasse;

public class Menu {

    public static String afficherMenu(String mdp) {
        boolean choix = true;
        while (choix) {

            System.out.println("""
                    Voulez-vous :
                    1 - Entrer un nouveau mot de passe
                    2 - Chiffrer votre mot de passe
                    3 - Hacher votre mot de passe
                    4 - Avoir de l'aide
                    5 - Quitter
                    """);
            System.out.println(mdp);

            Scanner scan = new Scanner(System.in);

            switch (scan.nextInt()) {
                case 1:
                    choix = false;
                    mdp = DemandeMotDePasse.demandeMotDePasse();
                    afficherMenu(mdp);
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
                default:
                    System.out.println("\nVotre choix n'est pas disponible\n");
            }
        }
        return mdp;
    }
}
