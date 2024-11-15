package polybe;

import java.util.HashMap;
import java.util.Map;


public class Polybe {

    private static final int TAILLE = 5; // Taille de la grille
    private static final char[][] grille = {{'A', 'B', 'C', 'D', 'E'}, {'F', 'G', 'H', 'I', 'K'}, // On
                                                                                                  // combinera
                                                                                                  // I
                                                                                                  // et
                                                                                                  // J
            {'L', 'M', 'N', 'O', 'P'}, {'Q', 'R', 'S', 'T', 'U'}, {'V', 'W', 'X', 'Y', 'Z'}};
    private static final Map<Character, String> mapCoordonnees = new HashMap<>(); // Map pour
                                                                                  // stocker les
                                                                                  // coordonnées des
                                                                                  // lettres

    // Initialise la grille de coordonnées
    static {
        for (int i = 0; i < TAILLE; i++) { // On parcourt la grille sur les lignes
            for (int j = 0; j < TAILLE; j++) { // On parcourt la grille sur les colonnes
                mapCoordonnees.put(grille[i][j], (i + 1) + "" + (j + 1)); // On ajoute les
                                                                          // coordonnées de la
                                                                          // lettre
            }
        }
    }

    public static String chiffrer(String texte) { // Chiffre un texte en utilisant la grille de
                                                  // coordonnées

        texte = texte.toUpperCase().replace("J", "I"); // Remplace J par I
        StringBuilder result = new StringBuilder(); // Résultat final

        for (char maLettre : texte.toCharArray()) { // On parcourt les lettres du texte
            if (mapCoordonnees.containsKey(maLettre)) { // On vérifie que la lettre est dans la
                                                        // grille
                result.append(mapCoordonnees.get(maLettre)).append(" "); // On ajoute les
                                                                         // coordonnées de la lettre
            }
        }
        return result.toString(); // On retourne le résultat
    }

    public static String dechiffrer(String code) { // Déchiffre un code en utilisant la grille de
                                                   // coordonnées
        StringBuilder resultat = new StringBuilder(); // Résultat final
        String[] paires = code.split(" "); // On sépare les paires

        for (String paire : paires) { // On parcourt les paires
            if (paire.length() == 2) { // On vérifie que la paire est bien de taille 2
                int ligne = Character.getNumericValue(paire.charAt(0)) - 1; // On récupère la ligne
                                                                            // -1 car on commence à
                                                                            // 0
                int colonne = Character.getNumericValue(paire.charAt(1)) - 1; // On récupère la
                                                                              // colonne -1 car on
                                                                              // commence à 0
                resultat.append(grille[ligne][colonne]); // On ajoute la lettre correspondante
            }
        }

        return resultat.toString(); // On retourne le résultat
    }
}
