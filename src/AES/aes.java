package AES;

import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class aes {

    public static void AES(String[] args) throws Exception {
        // Génère une clé secrète pour l'algorithme AES
        SecretKey cle = KeyGenerator.getInstance("AES").generateKey();
        try (Scanner scanner = new Scanner(System.in)) {
            // Demande à l'utilisateur de saisir le texte à chiffrer
            System.out.print("Texte à chiffrer : ");
            String texte = scanner.nextLine();

            // Chiffre le texte saisi par l'utilisateur
            String chiffre = chiffrer(texte, cle);
            // Affiche le texte chiffré
            System.out.println("Chiffré : " + chiffre);
        } catch (Exception e) {
            // Affiche un message d'erreur en cas d'exception
            System.out.println("Erreur : " + e.getMessage());
        }
    }

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
