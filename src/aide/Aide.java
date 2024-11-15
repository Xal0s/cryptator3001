package aide;

import java.util.Scanner;
import menu.Menu;

public class Aide {
    public static void afficherAide(String mdp) {

        try (Scanner sc = new Scanner(System.in)) {
            Boolean choix = true;

            System.out.println(
                    """
                            Sur PaKassable, vous avez la possibilit\u00e9 de chiffrer/d\u00e9chiffrer et de hacher un mot de passe avec plusieurs methode differentes:
                            Sur quelle fonction souhaitez vous de l'aide ?
                            """);
            while (choix) {
                System.out.println("""
                        1 - Chiffrage/D\u00e9chiffrage
                        2 - Hachage
                        3 - Retour
                        4 - Quitter
                        """);
                System.out.print(mdp);
                try {
                    switch (sc.nextInt()) {
                        case 1:
                            choix = false;
                            AideChiffrage.afficherAideChiffrage(mdp);
                            break;
                        case 2:
                            choix = false;
                            AideHachage.afficherAideHachage();
                            break;
                        case 3:
                            choix = false;
                            mdp = Menu.afficherMenu(mdp);
                            break;
                        case 4:
                            choix = false;
                            System.exit(0);
                        default:
                            System.out.println("Ce n'est pas un choix valide");
                    }
                } catch (Exception e) {
                    System.out.println("Ce n'est pas une valeure valide");
                    sc.nextLine();
                    afficherAide(mdp);
                }
            }
        }


    }
}
