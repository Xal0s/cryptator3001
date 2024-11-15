package vigenere;

import java.util.Scanner;

public class DechiffrementVigenere {

    public static String dechiffrementVigenere(String message, String cle) {
        // Boucle "for" pour parcourir chaque caractère de la variable message
        for (int i = 0; i < message.length(); i++) {

            // Récupération du caractère à la position "i" dans la chaîne "message"
            char ci = message.charAt(i);
            char ki = cle.charAt(i % cle.length());

            // Calcul du caractère chiffré :
            // ci - 'a' : Conversion du caractère en une position "normal" dans l'alphabet (a = 0, b
            // = 1, etc) au lieu de l'ordre ASCII (a = 97, b = 98, etc)
            // - (ki - 'a) : Conversion du caractère en une position "normal" dans l'alphabet (a =
            // 0, b = 1, etc) au lieu de l'ordre ASCII (a = 97, b = 98, etc)
            // +26 pour gérer les valeurs négatives
            // % 26 : modulo 26, pour rendre l'alphabet circulaire (xyz = abc)
            // + 'a' : Conversion de la position "normal" en un caractère de l'alphabet ASCII pour
            // que l'ordinateur puisse comprendre
            char charDechiffre = (char) (((ci - 'a' - (ki - 'a') + 26) % 26) + 'a');
            // Affiche le message chiffré
            message = String.valueOf(charDechiffre);
        }
        return message;

    }
}
