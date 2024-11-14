package aide;

import java.util.Scanner;

public class AideHachage {
    public static void afficherAideHachage() {
        boolean choix = true;
        while (choix) {

            System.out.println(
                    "Sur quelle methode de hash avez vous besoin d'aide ? :\n" +
                            "1 - MD5 \n" +
                            "2 - Sha-256\n" +
                            "3 - Retour\n" +
                            "4 - Quitter\n"
            );

            Scanner scan = new Scanner(System.in);
            try{
                switch (scan.nextInt()) {
                    case 1:
                        choix = false;
                        MD5.afficherAideMD5();
                        break;
                    case 2:
                        choix = false;
                        Sha256.afficherAideSha256();
                        break;
                    case 3:
                        Aide.afficherAide();
                        break;
                    case 4:
                        System.exit(0);
                    default: System.out.println("\nVotre choix n'est pas disponible\n");
                }
            }catch(Exception e){
                System.out.println("\nVeuillez entrer un choix valide\n");
                scan.nextLine();

            }
        }
    }
}
