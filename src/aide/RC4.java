package aide;

public class RC4 {
    public static void afficherAideRC4(String mdp) {
        System.out.println(
                """
                        L'algorithme commence par g\u00e9n\u00e9rer un tableau de permutation \u00e0 partir de la cl\u00e9, qui contient une s\u00e9rie de nombres m\u00e9lang\u00e9s.
                        Le tableau est ensuite utilis\u00e9 pour g\u00e9n\u00e9rer un flux de cl\u00e9s pseudo-al\u00e9atoire.
                         Ce flux est combin\u00e9 avec le message \u00e0 chiffrer, g\u00e9n\u00e9ralement par une op\u00e9ration XOR (ou "ou exclusif").
                        Pour chaque caract\u00e8re du message, le flux de cl\u00e9s est appliqu\u00e9 avec une op\u00e9ration XOR.
                         Le m\u00eame processus est utilis\u00e9 pour d\u00e9chiffrer le message, puisque l'op\u00e9ration XOR avec la m\u00eame cl\u00e9 annule l'effet du chiffrement.
                        """);
        AideChiffrage.afficherAideChiffrage(mdp);
    }
}
