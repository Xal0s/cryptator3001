package aide;

public class Sha256 {
    public static void afficherAideSha256() {
        System.out.println(
            "SHA-256 prend un message de n'importe quelle longueur.\n" +
            "Il génère une empreinte (ou \"digest\") de 256 bits (32 octets), qui est unique pour chaque message.\n" +
            "L'empreinte est fixe et il est pratiquement impossible de retrouver le message original à partir de l'empreinte. \n" +
            "De plus, il est impossible de trouver deux messages différents produisant la même empreinte (ce qu'on appelle une \"collision\")."
        );
        AideHachage.afficherAideHachage();
    }
}
