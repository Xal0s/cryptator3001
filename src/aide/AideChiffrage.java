package aide;

import java.util.Scanner;

public class AideChiffrage {
    public static void afficherAideChiffrage(String mdp) {
        while (true) {
            boolean choix = true;
            while (choix) {
                System.out.println("""
                        Sur quelle methode de chiffrement avez vous besoin d'aide ? :
                        1 - Rotation(x)
                        2 - Vigen\u00e8re
                        3 - Carr\u00e9 de Polybe
                        4 - Enigma
                        5 - RC4
                        6 - Retour
                        7 - Quitter
                        """);
                System.out.print(mdp);
                try (Scanner scan = new Scanner(System.in)) {
                    try {
                        switch (scan.nextInt()) {
                            case 1:
                                choix = false;
                                RotaX.afficherAideRotaX(mdp);
                                afficherAideChiffrage(mdp);
                                break;
                            case 2:
                                choix = false;
                                Vigenere.afficherAideVigenere(mdp);
                                afficherAideChiffrage(mdp);
                                break;
                            case 3:
                                choix = false;
                                Polybe.afficherAidePolybe(mdp);
                                afficherAideChiffrage(mdp);
                                break;
                            case 4:
                                choix = false;
                                Enigma.afficherAideEnigma(mdp);
                                afficherAideChiffrage(mdp);
                                break;
                            case 5:
                                RC4.afficherAideRC4(mdp);
                                afficherAideChiffrage(mdp);
                                break;
                            case 6:
                                Aide.afficherAide(mdp);
                                break;
                            case 7:
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
    }
}
