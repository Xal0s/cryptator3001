package menu;

import aide.Aide;

import java.util.Scanner;

public class Menu {

    public static void afficherMenu() {

        System.out.println(
                "****************************\n" +
                "**Bienvenue sur PaKassable**\n" +
                "****************************\n"
        );
        boolean choix = true;
        while (choix) {

            System.out.println(
                    "Voulez-vous :\n" +
                    "1 - Chiffrer votre mot de passe \n" +
                    "2 - Hacher votre mot de passe\n" +
                    "3 - Avoir de l'aide\n" +
                    "4 - Quitter\n"
            );

            Scanner scan = new Scanner(System.in);
            try{
                switch (scan.nextInt()) {
                    case 1:
                        choix = false;
                        System.out.println("Le choix 1 ");
                        break;
                    case 2:
                        choix = false;
                        System.out.println("Le choix 2 ");
                        break;
                    case 3:
                        choix = false;
                        Aide.afficherAide();
                        break;
                    case 4:
                        System.exit(0);
                    default: System.out.println("\nVotre choix n'est pas disponible\n");
                }
            }catch(Exception e){
                System.out.println("\nVeuillez entrer un chiffre valide\n");
            }

        }

    }
}
