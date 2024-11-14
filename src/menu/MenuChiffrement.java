package menu;

import RC4.RC4;
import aide.Aide;
import java.util.Scanner;
import polybe.Polybe;
import rotationX.ChiffrementRotation;
import vigenere.ChiffrementVigenere;

public class MenuChiffrement {
    public static void afficherMenuChiffrement(String mdp) {
        boolean choix = true;
        String cle = null;
        String decalageStr;
        int decalage;
        Scanner scanner = new Scanner(System.in);

        while (choix) {
            System.out.println("""
                    Quel algorithme voulez-vous utiliser ? :
                    1 - Rotation (Rotax)
                    2 - Vigenère
                    3 - RC4
                    4 - Carré de Polybe
                    5 - Enigma
                    6 - Avoir de l'aide
                    7 - Retour
                    8 - Quitter
                    """);
            System.out.println("Mot de passe actuel : " + mdp);

            // Lire l'option choisie par l'utilisateur
            int option = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (option) {
                case 1:
                    // Vérification des caractères dans le mot de passe pour Rotation (Rotax)
                    if (!mdp.matches("[a-zA-Z]+")) { // Exclut les chiffres et les espaces
                        System.out.println(
                                "Le chiffrement par rotation ne supporte pas les chiffres ni les caractères spéciaux.");
                        break;
                    }
                    // Boucle pour demander un décalage valide
                    while (true) {
                        System.out.print("Entrez le décalage souhaité (nombre positif) : ");
                        decalageStr = scanner.nextLine();
                        if (decalageStr.matches("\\d+")) {
                            decalage = Integer.parseInt(decalageStr);
                            break;
                        } else {
                            System.out
                                    .println("Veuillez entrer un nombre valide pour le décalage.");
                        }
                    }
                    mdp = ChiffrementRotation.chiffrementRotation(mdp, decalage);
                    System.out.println("Résultat : " + mdp);
                    Menu.afficherMenu(mdp);
                    break;

                case 2:
                    // Vérification des caractères dans le mot de passe pour Vigenère
                    if (!mdp.matches("[a-zA-Z]+")) { // Exclut les chiffres et les caractères
                                                     // spéciaux
                        System.out.println(
                                "Le chiffrement de Vigenère ne supporte pas les chiffres ni les caractères spéciaux.");
                        break;
                    }
                    // Boucle pour demander une clé valide
                    while (true) {
                        System.out.print(
                                "Entrez la clé en lettres uniquement (sans espaces ni caractères spéciaux) : ");
                        cle = scanner.nextLine();
                        if (cle.matches("[a-zA-Z]+")) {
                            cle = cle.toLowerCase(); // Convertir en minuscules si nécessaire
                            break;
                        } else {
                            System.out.println(
                                    "La clé doit contenir uniquement des lettres (sans espaces ni caractères spéciaux). Veuillez réessayer.");
                        }
                    }
                    mdp = ChiffrementVigenere.chiffrementVigenere(mdp, cle);
                    System.out.println("Résultat : " + mdp);
                    Menu.afficherMenu(mdp);
                    break;

                case 3:
                    System.out.println("Entrez une clé pour chiffrer le message");
                    cle = scanner.nextLine();
                    if (cle != null) {
                        mdp = RC4.utilisationRC4(mdp, cle);
                        System.out.println("Résultat : " + mdp);
                    } else {
                        System.out.println("La clé est null");
                    }
                    Menu.afficherMenu(mdp);
                    break;

                case 4:
                    // Vérification des caractères dans le mot de passe pour le carré de Polybe
                    if (!mdp.matches("[a-zA-Z]+")) { // Exclut les chiffres et les espaces
                        System.out.println(
                                "Le carré de Polybe ne supporte pas les chiffres ni les caractères spéciaux.");
                        break;
                    }
                    mdp = Polybe.chiffrer(mdp);
                    System.out.println("Résultat : " + mdp);
                    Menu.afficherMenu(mdp);
                    break;

                case 5:
                    choix = false;
                    System.out.println("C'est pas prêt");
                    break;

                case 6:
                    choix = false;
                    Aide.afficherAide(mdp);
                    break;

                case 7:
                    choix = false;
                    Menu.afficherMenu(mdp);
                    break;

                case 8:
                    System.exit(0);

                default:
                    System.out.println("\nVotre choix n'est pas disponible\n");
            }
        }
    }
}
