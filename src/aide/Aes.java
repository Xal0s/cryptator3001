package aide;

public class Aes {
    public static String afficherAideAes(String mdp) {
        System.out.println(
                """
                        L'AES (Advanced Encryption Standard) est un algorithme de chiffrement sym\u00e9trique qui remplace le DES (Data Encryption Standard).
                        Il utilise des blocs de 128 bits et des cl\u00e9s de 128, 192 ou 256 bits.
                        L'algorithme AES chiffre les donn\u00e9es par \u00e9tapes, en appliquant des transformations \u00e0 chaque tour.
                        Ces transformations incluent des substitutions non lin\u00e9aires, des permutations et des op\u00e9rations XOR.
                        L'AES est consid\u00e9r\u00e9 comme s\u00fbr et efficace, et il est largement utilis\u00e9 pour le chiffrement de donn\u00e9es.
                        """);
        return mdp;
    }

}
