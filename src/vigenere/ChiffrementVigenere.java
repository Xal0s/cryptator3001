package vigenere;

import menu.Menu;

import java.util.Scanner;

public class ChiffrementVigenere  {

    public static String chiffrementVigenere(String mdp, String cle) {

        System.out.print("Voici votre message chiffré : ");
        // Boucle "for" pour parcourir chaque caractère de la variable message
        for  (int i = 0; i<mdp.length(); i++){

            // Récupération du caractère à la position "i" dans la chaîne "message"
            char ci = mdp.charAt(i);
            char ki = cle.charAt(i % cle.length());

            // Calcul du caractère chiffré :
            // (ci - 'a') : Conversion du caractère en une position "normal" dans l'alphabet (a = 0, b = 1, etc) au lieu de l'ordre ASCII (a = 97, b = 98, etc)
            // ki - 'a' : Conversion du caractère en une position "normal" dans l'alphabet (a = 0, b = 1, etc) au lieu de l'ordre ASCII (a = 97, b = 98, etc)
            // % 26 : modulo 26, pour rendre l'alphabet circulaire (xyz = abc)
            // + 'a' : Conversion de la position "normal" en un caractère de l'alphabet ASCII pour que l'ordinateur puisse comprendre
            char charChiffre = (char) ((( ci - 'a' + ki - 'a') % 26) + 'a');
        };

        return mdp;
    }
}
