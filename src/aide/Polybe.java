package aide;

public class Polybe {
    public static void afficherAidePolybe() {
        System.out.println(
            "On construit une grille de 5 lignes et 5 colonnes, avec les lettres de l’alphabet.\n" +
            " Comme il n'y a que 26 lettres et que la grille en contient seulement 25, on combine généralement les lettres \"I\" et \"J\" dans une seule case.\n" +
            "Chiffrement : Pour chaque lettre du message, on la remplace par ses coordonnées dans la grille. Par exemple :\n" +
            "\"A\" devient \"11\" (ligne 1, colonne 1)\n" +
            "\"B\" devient \"12\" (ligne 1, colonne 2)\n" +
            "\"J\" (ou \"I\") devient \"24\" (ligne 2, colonne 4)\n" +
            "Déchiffrement : Pour retrouver le message, il suffit de prendre les chiffres, les séparer en paires, puis de chercher la lettre correspondante dans la grille.\n"
        );
        AideChiffrage.afficherAideChiffrage();
    }
}
