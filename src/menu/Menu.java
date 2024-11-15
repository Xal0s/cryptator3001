package menu;

import aide.Aide;
import motDePasse.DemandeMotDePasse;
import sauvegarde.Sauvegarde;
import java.util.Scanner;

public class Menu {

    public static String afficherMenu(String mdp) {
        boolean choix = true;
        while (choix) {

            System.out.println(
                "Que voulez-vous faire ? :\n" +
                "1 - Entrer un nouveau mot de passe\n"+
                "2 - Chiffrer votre mot de passe \n" +
                "3 - Hacher votre mot de passe\n" +
                "4 - Dechiffrer votre mot de passe\n"+
                "5 - Sauvegarde\n" +
                "6 - Avoir de l'aide\n" +
                "7 - Quitter\n"
            );
            System.out.println(mdp);

            Scanner scan = new Scanner(System.in);

            try {
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
                        MenuDechiffrement.afficherMenuDechiffrement(mdp);
                    case 5:
                        choix = false;
                        Sauvegarde.SauvegardeMdp(mdp);
                        Menu.afficherMenu(mdp);
                        break;
                    case 6:
                        choix = false;
                        Aide.afficherAide(mdp);
                        break;
                    case 7:
                        System.exit(0);
                    default:
                        System.out.println("\nVotre choix n'est pas disponible\n");
                }
            } catch (Exception e) {
                System.out.println("\nVeuillez entrer un chiffre valide\n");
                scan.nextLine();
            }
        }
        return mdp;
    }
}
