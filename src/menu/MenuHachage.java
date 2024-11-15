package menu;

import aide.Aide;
import hash.MD5;
import hash.Sha256;
import java.util.Scanner;

public class MenuHachage {

    public static void afficherMenuHachage(String mdp) {
        while (true) {
            boolean choix = true;
            while (choix) {
                System.out.println("""
                        Quel algorithme voulez-vous utiliser ? :
                        1 - MD5
                        2 - Sha-256
                        3 - Avoir de l'aide
                        4 - Retour
                        5 - Quitter
                        """);

                System.out.println(mdp);

                try (Scanner scan = new Scanner(System.in)) {
                    try {
                        switch (scan.nextInt()) {
                            case 1:
                                choix = false;
                                mdp = MD5.convertirEnMD5(mdp);
                                Menu.afficherMenu(mdp);
                                break;
                            case 2:
                                choix = false;
                                mdp = Sha256.convertirEnSha256(mdp);
                                Menu.afficherMenu(mdp);
                                break;
                            case 3:
                                choix = false;
                                Aide.afficherAide(mdp);
                                break;
                            case 4:
                                choix = false;
                                Menu.afficherMenu(mdp);
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("\nVotre choix n'est pas disponible\n");
                        }
                    } catch (Exception e) {
                        System.out.println("\nVeuillez entrer un chiffre valide\n");
                        menu.Menu.afficherMenu(mdp);
                    }
                }
            }
        }
    }
}
