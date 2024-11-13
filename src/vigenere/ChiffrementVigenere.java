package vigenere;

import java.util.Scanner;

public class ChiffrementVigenere  {

    public static void chiffrementVigenere() {

        // Création d'un objet Scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        String message;

        //Boucle while pour demander à l'utilisateur d'entrer un message valide
        while (true) {
            // Demander à l'utilisateur d'entrer le message à chiffrer
            System.out.print("Entrez le message à chiffrer en lettres uniquement (sans espaces ni caractères spéciaux) : ");

            //lit ce que l'utilisateur entre et le stock dans la variable message
            message = scanner.nextLine();

            // Vérifier si le message contient uniquement des lettres alphabétiques
            if (message.matches("[a-zA-Z]+")) {
                // Convertir en minuscules pour le chiffrement
                message = message.toLowerCase();
                break;
            } else {
                System.out.println("Le message doit contenir uniquement des lettres (sans espaces ni caractères spéciaux). Veuillez réessayer.");
            }
        }

        String cle;
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

        System.out.print("Voici votre message chiffré : ");
        // Boucle "for" pour parcourir chaque caractère de la variable message
        for  (int i = 0; i<message.length(); i++){

            // Récupération du caractère à la position "i" dans la chaîne "message"
            char ci = message.charAt(i);
            char ki = cle.charAt(i % cle.length());

            // Calcul du caractère chiffré :
            // (ci - 'a') : Conversion du caractère en une position "normal" dans l'alphabet (a = 0, b = 1, etc) au lieu de l'ordre ASCII (a = 97, b = 98, etc)
            // ki - 'a' : Conversion du caractère en une position "normal" dans l'alphabet (a = 0, b = 1, etc) au lieu de l'ordre ASCII (a = 97, b = 98, etc)
            // % 26 : modulo 26, pour rendre l'alphabet circulaire (xyz = abc)
            // + 'a' : Conversion de la position "normal" en un caractère de l'alphabet ASCII pour que l'ordinateur puisse comprendre
            char charChiffre = (char) ((( ci - 'a' + ki - 'a') % 26) + 'a');
            // Affiche le message chiffré
            System.out.print(charChiffre);
        };

        // Fermeture du scanner
        scanner.close();

    }
}
