package menu;

import RC4.RC4;
import aide.Aide;
import java.util.Scanner;
import polybe.Polybe;
import rotationX.ChiffrementRotation;
import sauvegarde.Sauvegarde;
import vigenere.ChiffrementVigenere;

public class MenuChiffrement {
    public static void afficherMenuChiffrement(String mdp) {
        String cle = null;
        String decalageStr;
        int decalage;
        Scanner scanner = new Scanner(System.in);
        System.out.println(
            "Quel algorithme voulez-vous utiliser ? :\n" +
            "1 - Rotation(x) \n" +
            "2 - Vigenère\n" +
            "3 - RC4\n" +
            "4 - Carré de Polybe\n" +
            "5 - Enigma\n" +
            "6 - Sauvegarder\n" +
            "7 - Avoir de l'aide\n" +
            "8 - Retour\n" +
            "9 - Quitter\n"
        );
        System.out.println(mdp);

        Scanner scan = new Scanner(System.in);
        try{
            switch (scan.nextInt()) {
                case 1:
                    //Boucle while pour demander à l'utilisateur d'entrer un décalage valide
                    while (true) {
                        // Demander à l'utilisateur d'entrer le décalage
                        System.out.print("Entrez le décalage souhaité (nombre positif) : ");

                        //Lit ce que l'utilisateur entre et le stock dans la variable decalageStr
                        decalageStr = scanner.nextLine();

                        // Vérifier si le décalage contient uniquement des chiffres
                        if (decalageStr.matches("\\d+")) {

                            //Conversion de la chaine de caractere en entier
                            decalage = Integer.parseInt(decalageStr);
                            break;
                        } else {
                            System.out.println("Veuillez entrer un nombre valide pour le décalage.");
                        }
                    }
                    mdp = ChiffrementRotation.chiffrementRotation(mdp, decalage);
                    System.out.println(mdp);
                    Menu.afficherMenu(mdp);
                    break;
                case 2:
                    scanner = new Scanner(System.in);
                    //Boucle while pour demander à l'utilisateur d'entrer un message valide
                    while (true) {
                        // Demander à l'utilisateur d'entrer le message à chiffrer
                        System.out.print("Entrez la clé en lettres uniquement (sans espaces ni caractères spéciaux) : ");

                        //lit ce que l'utilisateur entre et le stock dans la variable message
                        cle = scanner.nextLine();

                        // Vérifier si le message contient uniquement des lettres alphabétiques
                        if (cle.matches("[a-zA-Z]+")) {
                            // Convertir en minuscules pour le chiffrement
                            cle = cle.toLowerCase();
                            break;
                        } else {
                            System.out.println("La clé doit contenir uniquement des lettres (sans espaces ni caractères spéciaux). Veuillez réessayer.");
                        }
                    }
                    mdp = ChiffrementVigenere.chiffrementVigenere(mdp, cle);
                    System.out.println(mdp);
                    Menu.afficherMenu(mdp);
                    break;
                case 3:
                    Scanner scan2 = new Scanner(System.in);
                    try {
                        System.out.println("Entrez une clé pour chiffrer le message");
                        cle = scan2.nextLine();
                    } catch (Exception e) {
                        System.out.println("Erreur dans la cle");
                    }
                    if (cle != null){
                        mdp = RC4.utilisationRC4(mdp, cle);
                    }else {
                        System.out.println("la cle est null");
                    }
                    System.out.println(mdp);
                    Menu.afficherMenu(mdp);
                    break;
                case 4:
                    mdp = Polybe.chiffrer(mdp);
                    System.out.println(mdp);
                    Menu.afficherMenu(mdp);
                    break;
                case 5:
                    System.out.println("C'est pas prêt");
                    break;
                case 6:
                    Sauvegarde.SauvegardeMdp(mdp);
                    break;
                case 7:
                    Aide.afficherAide(mdp);
                    break;
                case 8 :
                    scan.nextLine();
                    Menu.afficherMenu(mdp);
                case 9:
                    System.exit(0);
                default:
                    System.out.println("\nVotre choix n'est pas disponible\n");
            }
        }catch(Exception e){
            System.out.println("\nVeuillez entrer un choix valide\n");
            scan.nextLine();
        }
    }
}
