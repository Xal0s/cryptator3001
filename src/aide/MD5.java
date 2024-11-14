package aide;

public class MD5 {
    public static void afficherAideMD5() {
        System.out.println(
            "MD5 prend un message de n'importe quelle longueur en entrée.\n" +
            "Il transforme ce message en une chaîne de 128 bits (16 octets), appelée \"empreinte\" ou \"digest\". Cela se fait par des opérations de hachage répétées sur le message.\n" +
            "L'empreinte est unique pour un message donné, et il est extrêmement difficile de retrouver le message original à partir de l'empreinte."
        );
        AideHachage.afficherAideHachage();
    }
}
