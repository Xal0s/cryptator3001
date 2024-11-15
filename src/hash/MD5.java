package hash;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    // Méthode pour convertir un message en MD5
    public static String convertirEnMD5(String entree) {

        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5"); // Instancie
                                                                                                 // un
                                                                                                 // objet
                                                                                                 // de
                                                                                                 // type
                                                                                                 // MessageDigest
                                                                                                 // avec
                                                                                                 // l'algorithme
                                                                                                 // MD5
            byte[] hash = digest.digest(entree.getBytes("UTF-8")); // Convertit l'entrée en tableau
                                                                   // de bytes et le hash
            StringBuilder chaineHexadecimale = new StringBuilder(); // Crée un objet de type
                                                                    // StringBuilder

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]); // Convertit le byte en
                                                                  // hexadécimal

                if (hex.length() == 1) {
                    chaineHexadecimale.append('0'); // Ajoute un 0 à la chaîne hexadécimale
                }
                chaineHexadecimale.append(hex); // Ajoute la chaîne hexadécimale à la chaîne
                                                // hexadécimale
            }

            return chaineHexadecimale.toString(); // Retourne la chaîne hexadécimale

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // Lève une exception
        }
    }
}
