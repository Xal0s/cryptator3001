package aide;

public class Polybe {
    public static String afficherAidePolybe(String mdp) {
        System.out.println(
                """
                        On construit une grille de 5 lignes et 5 colonnes, avec les lettres de l\u2019alphabet.
                         Comme il n'y a que 26 lettres et que la grille en contient seulement 25, on combine g\u00e9n\u00e9ralement les lettres "I" et "J" dans une seule case.
                        Chiffrement : Pour chaque lettre du message, on la remplace par ses coordonn\u00e9es dans la grille. Par exemple :
                        "A" devient "11" (ligne 1, colonne 1)
                        "B" devient "12" (ligne 1, colonne 2)
                        "J" (ou "I") devient "24" (ligne 2, colonne 4)
                        D\u00e9chiffrement : Pour retrouver le message, il suffit de prendre les chiffres, les s\u00e9parer en paires, puis de chercher la lettre correspondante dans la grille.
                        """);
        return mdp;
    }
}
