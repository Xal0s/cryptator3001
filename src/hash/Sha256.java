package hash;
import menu.Menu;

import java.security.MessageDigest;
import java.util.Scanner;

public class Sha256 {

    public static void convertirEnSha256() {

        Scanner scanner = new Scanner(System.in);
        String entree = "";

        System.out.println("Entrez un message a hacher :");
        try{
            entree = scanner.nextLine();
        }catch(Exception e){
            System.out.println("Une erreur est survenue");
        }

        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Instancie un objet de type MessageDigest avec l'algorithme SHA-256
            final byte[] hash = digest.digest(entree.getBytes("UTF-8")); // Convertit l'entrée en tableau de bytes et le hash
            final StringBuilder chaineHexadecimale = new StringBuilder(); // Crée un objet de type StringBuilder



            for (int i = 0; i < hash.length; i++) { // Parcours le tableau de bytes
                final String hex = Integer.toHexString(0xff & hash[i]); // Convertit le byte en hexadécimal

                if(hex.length() == 1) { // Si la longueur de la chaîne hexadécimale est égale à 1
                    chaineHexadecimale.append('0'); // Ajoute un 0 à la chaîne hexadécimale
                }
                chaineHexadecimale.append(hex); // Ajoute la chaîne hexadécimale à la chaîne hexadécimale
            }

            System.out.println(chaineHexadecimale);

            Menu.afficherMenu();

        } catch(Exception e) { // Si une exception est levée
            throw new RuntimeException(e); // Lève une exception
        }
    }
}
