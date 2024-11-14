package rotationX;

import java.util.Scanner;

public class DechiffrementRotation {

    public static void dechiffrementRotation() {
        // Création d'un objet Scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        String message;

        //Boucle while pour demander à l'utilisateur d'entrer un message valide
        while (true) {
            // Demander à l'utilisateur d'entrer le message à déchiffrer
            System.out.print("Entrez le message à déchiffrer en lettres uniquement (sans espaces ni caractères spéciaux) : ");

            //Lit ce que l'utilisateur entre et le stock dans la variable message
            message = scanner.nextLine();

            // Vérifier si le message contient uniquement des lettres alphabétiques
            if (message.matches("[a-zA-Z]+")) {
                // Convertir en minuscules pour le déchiffrement
                message = message.toLowerCase();
                break;
            } else {
                System.out.println("Le message doit contenir uniquement des lettres (sans espaces ni caractères spéciaux). Veuillez réessayer.");
            }
        }


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

        System.out.print("Voici votre message déchiffré : ");
        // Boucle "for" pour parcourir chaque caractère de la variable message
        for  (int i = 0; i<message.length(); i++){

            // Récupération du caractère à la position "i" dans la chaîne "message"
            char ci = message.charAt(i);

            // Calcul du caractère à déchiffré :
            // (ci - 'a') : Conversion du caractère en une position "normal" dans l'alphabet (a = 0, b = 1, etc) au lieu de l'ordre ASCII (a = 97, b = 98, etc)
            // + decalage : Application du décalage choisi par l'utilisateur
            // % 26 : modulo 26, pour rendre l'alphabet circulaire (xyz = abc)
            // + 'a' : Conversion de la position "normal" en un caractère de l'alphabet ASCII pour que l'ordinateur puisse comprendre
            char charDechiffre = (char) (((ci - 'a' - decalage) % 26) + 'a');
            // Affiche le message déchiffré
            System.out.print(charDechiffre);
        };

        // Fermeture du scanner
        scanner.close();
    }
}
