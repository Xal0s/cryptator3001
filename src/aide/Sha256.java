package aide;

public class Sha256 {
    public static void afficherAideSha256() {
        System.out.println(
                """
                        SHA-256 prend un message de n'importe quelle longueur.
                        Il g\u00e9n\u00e8re une empreinte (ou "digest") de 256 bits (32 octets), qui est unique pour chaque message.
                        L'empreinte est fixe et il est pratiquement impossible de retrouver le message original \u00e0 partir de l'empreinte.
                        De plus, il est impossible de trouver deux messages diff\u00e9rents produisant la m\u00eame empreinte (ce qu'on appelle une "collision").""");
        AideHachage.afficherAideHachage();
    }
}
