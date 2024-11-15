package menu;

import AES.aes;
import RC4.RC4;
import aide.Aide;
import java.util.Scanner;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import polybe.Polybe;
import rotationX.DechiffrementRotation;
import sauvegarde.Sauvegarde;
import vigenere.DechiffrementVigenere;

public class MenuDechiffrement {
    public static void afficherMenuDechiffrement(String mdp) {
        while (true) {
            String cle = null;
            String decalageStr;
            int decalage;
            boolean choix = true;
            while (choix) {
                System.out.println("""
                        Quel algorithme voulez-vous utiliser ? :
                        1 - Rotation(x)
                        2 - Vigen\u00e8re
                        3 - RC4
                        4 - Carr\u00e9 de Polybe
                        5 - AES
                        6 - Sauvegarder
                        7 - Avoir de l'aide
                        8 - Retour
                        9 - Quitter
                        """);
                System.out.println(mdp);

                try (Scanner scanner = new Scanner(System.in)) {
                    try {
                        switch (scanner.nextInt()) {
                            case 1:
                                // Boucle while pour demander à l'utilisateur d'entrer un décalage
                                // valide
                                while (true) {
                                    // Demander à l'utilisateur d'entrer le décalage
                                    System.out.print(
                                            "Entrez le décalage souhaité (nombre positif) : ");

                                    // Lit ce que l'utilisateur entre et le stock dans la variable
                                    // decalageStr
                                    decalageStr = scanner.nextLine();

                                    // Vérifier si le décalage contient uniquement des chiffres
                                    if (decalageStr.matches("\\d+")) {
                                        // Conversion de la chaine de caractere en entier
                                        decalage = Integer.parseInt(decalageStr);
                                        break;
                                    } else {
                                        System.out.println(
                                                "Veuillez entrer un nombre valide pour le décalage.");
                                    }
                                }
                                mdp = DechiffrementRotation.dechiffrementRotation(mdp, decalage);
                                System.out.println(mdp);
                                Menu.afficherMenu(mdp);
                                break;
                            case 2:
                                scanner.nextLine(); // Consommer la nouvelle ligne
                                // Boucle while pour demander à l'utilisateur d'entrer un message
                                // valide
                                while (true) {
                                    // Demander à l'utilisateur d'entrer le message à chiffrer
                                    System.out.print(
                                            "Entrez la clé en lettres uniquement (sans espaces ni caractères spéciaux) : ");

                                    // lit ce que l'utilisateur entre et le stock dans la variable
                                    // message
                                    cle = scanner.nextLine();

                                    // Vérifier si le message contient uniquement des lettres
                                    // alphabétiques
                                    if (cle.matches("[a-zA-Z]+")) {
                                        // Convertir en minuscules pour le chiffrement
                                        cle = cle.toLowerCase();
                                        break;
                                    } else {
                                        System.out.println(
                                                "La clé doit contenir uniquement des lettres (sans espaces ni caractères spéciaux). Veuillez réessayer.");
                                    }
                                }
                                mdp = DechiffrementVigenere.dechiffrementVigenere(mdp, cle);
                                System.out.println(mdp);
                                Menu.afficherMenu(mdp);
                                break;
                            case 3:
                                scanner.nextLine(); // Consommer la nouvelle ligne
                                System.out.println("Entrez une clé pour chiffrer le message");
                                cle = scanner.nextLine();
                                if (cle != null) {
                                    mdp = RC4.utilisationRC4(mdp, cle);
                                } else {
                                    System.out.println("La clé est null");
                                }
                                System.out.println(mdp);
                                Menu.afficherMenu(mdp);
                                break;
                            case 4:
                                mdp = Polybe.dechiffrer(mdp);
                                System.out.println(mdp);
                                Menu.afficherMenu(mdp);
                                break;
                            case 5:
                                scanner.nextLine();
                                System.out.println("Entrez votre clé secrète (16 caractères) : ");
                                String cleUtilisateur = scanner.nextLine();
                                try {
                                    // Créer une clé à partir de l'entrée utilisateur
                                    byte[] cleBytes = cleUtilisateur.getBytes();
                                    SecretKey cleAES = new SecretKeySpec(cleBytes, "AES");

                                    // Déchiffrer le message
                                    mdp = aes.dechiffrer(mdp, cleAES);
                                    System.out.println("Message déchiffré : " + mdp);
                                    Menu.afficherMenu(mdp);
                                } catch (Exception e) {
                                    System.out.println(
                                            "Erreur lors du déchiffrement AES : " + e.getMessage());
                                }
                                break;
                            case 6:
                                Sauvegarde.SauvegardeMdp(mdp);
                                break;
                            case 7:
                                Aide.afficherAide(mdp);
                                break;
                            case 8:
                                scanner.nextLine();
                                Menu.afficherMenu(mdp);
                                break;
                            case 9:
                                System.exit(0);
                            default:
                                System.out.println("\nVotre choix n'est pas disponible\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\nVeuillez entrer un chiffre valide\n");
                        scanner.nextLine();
                    }
                }
            }
        }
    }
}
