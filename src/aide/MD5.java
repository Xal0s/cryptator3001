package aide;

public class MD5 {
    public static void afficherAideMD5() {
        System.out.println(
                """
                        MD5 prend un message de n'importe quelle longueur en entr\u00e9e.
                        Il transforme ce message en une cha\u00eene de 128 bits (16 octets), appel\u00e9e "empreinte" ou "digest". Cela se fait par des op\u00e9rations de hachage r\u00e9p\u00e9t\u00e9es sur le message.
                        L'empreinte est unique pour un message donn\u00e9, et il est extr\u00eamement difficile de retrouver le message original \u00e0 partir de l'empreinte.""");
        AideHachage.afficherAideHachage();
    }
}
