package menu;


import aide.Aide;
import hash.MD5;
import hash.Sha256;


import java.util.Scanner;

public class MenuHachage {

    public static void afficherMenuHachage(String mdp) {

        boolean choix = true;
        while (choix) {

            System.out.println(
                    "Quel algorithme voulez-vous utiliser ? :\n" +
                    "1 - MD5 \n" +
                    "2 - Sha-256\n" +
                    "3 - Avoir de l'aide\n" +
                    "4 - Quitter\n"
            );

            System.out.println(mdp);

            Scanner scan = new Scanner(System.in);
            try {
                switch (scan.nextInt()) {
                    case 1:
                        choix = false;
                        MD5.convertirEnMD5(mdp);
                        break;
                    case 2:
                        choix = false;
                        Sha256.convertirEnSha256(mdp);
                        break;
                    case 3:
                        choix = false;
                        Aide.afficherAide(mdp);
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("\nVotre choix n'est pas disponible\n");
                }
            } catch (Exception e) {
                System.out.println("\nVeuillez entrer un chiffre valide\n");
            }
        }
    }
}
