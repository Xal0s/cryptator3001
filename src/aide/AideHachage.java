package aide;

import java.util.Scanner;

public class AideHachage {
    public static void afficherAideHachage() {
        boolean choix = true;
        String mdp = null;
        while (choix) {

            System.out.println("""
                    Sur quelle methode de hash avez vous besoin d'aide ? :
                    1 - MD5
                    2 - Sha-256
                    3 - Retour
                    4 - Quitter
                    """);
            System.out.print(mdp);
            Scanner scan = new Scanner(System.in);
            try {
                switch (scan.nextInt()) {
                    case 1:
                        choix = false;
                        MD5.afficherAideMD5();
                        afficherAideHachage();
                        break;
                    case 2:
                        choix = false;
                        Sha256.afficherAideSha256();
                        afficherAideHachage();
                        break;
                    case 3:
                        Aide.afficherAide(mdp);
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("\nVotre choix n'est pas disponible\n");
                }
            } catch (Exception e) {
                System.out.println("\nVeuillez entrer un choix valide\n");
                scan.nextLine();

            }
        }
    }
}
