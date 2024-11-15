package enigma;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anneau{

    public static void anneau() {
        // Tableau double dimensions contenant les configurations de décalages pour chaque position de l'anneau
        int[][] configurations = {
                //Configuration du décalage de chaque lettre pour chaque anneau de 1 à 26, pour l'instant j'en met que 4

                {3, 15, 27, 4, 18, 12, 24, 6, 21, 13, 8, 9, 29, 10, 7, 2, 25, 1, 14, 17, 22, 5, 20, 30, 23, 26},
                {8, 1, 20, 19, 7, 12, 23, 11, 30, 25, 9, 4, 15, 6, 2, 16, 28, 5, 27, 3, 21, 13, 17, 24, 18, 22},
                {10, 4, 6, 25, 28, 11, 1, 5, 23, 13, 12, 18, 9, 27, 15, 2, 19, 14, 7, 22, 3, 30, 21, 16, 26, 17},
                {14, 20, 1, 18, 6, 27, 19, 24, 5, 12, 25, 11, 15, 2, 28, 30, 17, 10, 22, 13, 21, 9, 7, 4, 3, 16}

        };

        Scanner scanner = new Scanner(System.in);
/*
        // Demande à l'utilisateur de saisir la position de l'anneau en entrant une lettre entre a et z,
        // conversion e minuscule dans le cas où l'utilisateur entre une majuscule
        // charAt(0) extrait le caractere
        System.out.print("Quelle est la position de l'anneau ? (lettre de a à z) : ");
        char choixAnneau = scanner.next().toLowerCase().charAt(0);

        // Vérifie que l'utilisateur a entré une lettre valide entre 'a' et 'z'
        if (choixAnneau < 'a' || choixAnneau > 'z') {
            System.out.println("Entrée invalide. Veuillez entrer une lettre de 'a' à 'z'.");
            return;
        }
*/

    char choixAnneau;

    while (true){
        // Demande à l'utilisateur de saisir la position de l'anneau en entrant une lettre entre a et z, (la c'est d pour tester)
        System.out.print("Quelle est la position de l'anneau ? (lettre de a à d) : ");

        // Lit ce que l'utilisateur entre et le stocke dans la variable choixAnneau
        String lettreChoisi = scanner.next();

        // Vérifie que le choix entree est une seule lettre et il se trouve bien entre 'a' et 'z'
        if (lettreChoisi.length()== 1 && lettreChoisi.matches ("[a-dA-D]")){
            // Si l'entrée est valide, convertit le caractère en minuscule et l'assigne à choixAnneau
            choixAnneau = Character.toLowerCase(lettreChoisi.charAt(0));
            break;
        }else{
            // Si l'entrée n'est pas valide, affiche un message d'erreur pour l'utilisateur
            System.out.println("Le message doit contenir uniquement une lettre de a à d. Veuillez réessayer.");

        }
    }

        //Conversion du caractère en une position "normal" dans l'alphabet (a = 0, b = 1, etc) au lieu de l'ordre ASCII (a = 97, b = 98, etc)
        int positionAnneau = choixAnneau - 'a';

        //Vérifie si la position est dans les limites des configurations (26)
        //Même si cette condition est évitée grace à la demande du choixAnneau
        //C'est tout de même une mesure de sécurité en plus quelle que soit a taille de configuration
        if (positionAnneau >= configurations.length) {
            System.out.println("Position d'anneau non configurée. Veuillez ajouter plus de configurations.");
            return;
        }

        // Récupére la configuration correspondant à la position de l'anneau (rotation pour chaque lettre)
        int[] configuration = configurations[positionAnneau];
        //decalages est une map qui associe chaque lettre (clé de type char) à son décalage (valeur de type Int)
        Map<Character, Integer> decalages = new HashMap<>();
        // Lettres à associer avec les décalages
        char[] lettres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        // Initialiser les décalages pour chaque lettre
        for (int i = 0; i < lettres.length; i++) {
            decalages.put(lettres[i], configuration[i]);
        }

        // Afficher la position de l'anneau choisie et les décalages
        System.out.println("Position de l'anneau choisie : " + (positionAnneau + 1));

        //decalages est une map qui associe chaque lettre (clé de type char) à son décalage (valeur de type Int)
        for (Map.Entry<Character, Integer> entry : decalages.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        scanner.close();


    }
}
