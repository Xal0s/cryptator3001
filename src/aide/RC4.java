package aide;

public class RC4 {
    public static void afficherAideRC4() {
        System.out.println(
            "L'algorithme commence par générer un tableau de permutation à partir de la clé, qui contient une série de nombres mélangés.\n" +
            "Le tableau est ensuite utilisé pour générer un flux de clés pseudo-aléatoire. Ce flux est combiné avec le message à chiffrer, généralement par une opération XOR (ou \"ou exclusif\").\n" +
            "Pour chaque caractère du message, le flux de clés est appliqué avec une opération XOR. Le même processus est utilisé pour déchiffrer le message, puisque l'opération XOR avec la même clé annule l'effet du chiffrement.\n"
        );
        AideChiffrage.afficherAideChiffrage();
    }
}
