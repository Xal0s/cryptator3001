package rotationX;

import menu.Menu;

import java.util.Scanner;

public class ChiffrementRotation {

    public static String chiffrementRotation(String message) {

        String decalageStr;
        int decalage;

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

        // Utiliser StringBuilder pour construire le message chiffré
        StringBuilder messageChiffre = new StringBuilder();

        System.out.print("Voici votre message chiffré : ");
        // Boucle "for" pour parcourir chaque caractère de la variable message
        for  (int i = 0; i<message.length(); i++){

            // Récupération du caractère à la position "i" dans la chaîne "message"
            char ci = message.charAt(i);

            // Calcul du caractère chiffré :
            // (ci - 'a') : Conversion du caractère en une position "normal" dans l'alphabet (a = 0, b = 1, etc) au lieu de l'ordre ASCII (a = 97, b = 98, etc)
            // + decalage : Application du décalage choisi par l'utilisateur
            // % 26 : modulo 26, pour rendre l'alphabet circulaire (xyz = abc)
            // + 'a' : Conversion de la position "normal" en un caractère de l'alphabet ASCII pour que l'ordinateur puisse comprendre
            char charChiffre = (char) (((ci - 'a' + decalage) % 26) + 'a');
            // Affiche le message chiffré
            System.out.print(charChiffre);
            messageChiffre.append(charChiffre);
        };

        // Fermeture du scanner
        scanner.close();
        return messageChiffre.toString();
    }
}
