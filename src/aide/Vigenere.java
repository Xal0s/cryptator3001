package aide;

public class Vigenere {
    public static void afficherAideVigenere() {
        System.out.println(
            "Le chiffrement de Vigenère remplace chaque lettre d’un message par une autre lettre, en fonction d’une clé secrète. \n" +
            "La méthode de Vigenère utilise une clé qui peut être plus courte ou aussi longue que le message à protéger.\n"
        );
        AideChiffrage.afficherAideChiffrage();
    }
}
