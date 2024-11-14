package AES;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class aes {
    // Méthode pour chiffrer un texte avec une clé secrète
    public static String chiffrer(String texte, SecretKey cle) throws Exception {
        // Initialise le chiffrement AES en mode chiffrement
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, cle);
        // Chiffre le texte et le convertit en base64
        byte[] texteCrypte = cipher.doFinal(texte.getBytes());
        return Base64.getEncoder().encodeToString(texteCrypte);
    }

    // Méthode pour déchiffrer un texte chiffré avec une clé secrète
    public static String dechiffrer(String texteCrypte, SecretKey cle) throws Exception {
        // Initialise le chiffrement AES en mode déchiffrement
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, cle);
        // Déchiffre le texte en base64 et le convertit en texte clair
        byte[] texteDecrypte = cipher.doFinal(Base64.getDecoder().decode(texteCrypte));
        return new String(texteDecrypte);
    }
}
