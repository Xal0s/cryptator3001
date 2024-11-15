package rotationX;

import java.util.Scanner;

public class DechiffrementRotation {

    public static String dechiffrementRotation(String message, String decalageStr) {

        int decalage = Integer.parseInt(decalageStr);
        // Boucle "for" pour parcourir chaque caractère de la variable message
        for (int i = 0; i < message.length(); i++) {

            // Récupération du caractère à la position "i" dans la chaîne "message"
            char ci = message.charAt(i);

            // Calcul du caractère à déchiffré :
            // (ci - 'a') : Conversion du caractère en une position "normal" dans l'alphabet (a = 0,
            // b = 1, etc) au lieu de l'ordre ASCII (a = 97, b = 98, etc)
            // + decalage : Application du décalage choisi par l'utilisateur
            // % 26 : modulo 26, pour rendre l'alphabet circulaire (xyz = abc)
            // + 'a' : Conversion de la position "normal" en un caractère de l'alphabet ASCII pour
            // que l'ordinateur puisse comprendre
            char charDechiffre = (char) (((ci - 'a' - decalage) % 26) + 'a');
            // Affiche le message déchiffré
            message = String.valueOf(charDechiffre);
        }
        return message;
    }
}
