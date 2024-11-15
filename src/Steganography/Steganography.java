package Steganography;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Steganography {

    // Cacher un message dans une image
    public static void cacherMessage(String cheminFichierEntree, String message) throws Exception {
        File fichierEntree = new File(cheminFichierEntree); // Charger le fichier à partir du chemin
        BufferedImage image = ImageIO.read(fichierEntree); // Lire l'image
        byte[] messageOctets = message.getBytes(); // Convertir le message en tableau d'octets
        int longueurMessage = messageOctets.length; // Longueur du message

        // Ajouter la longueur du message dans les premiers pixels
        for (int i = 0; i < 32; i++) {
            int pixel = image.getRGB(i % image.getWidth(), i / image.getWidth()); // Récupérer le pixel
            int bleu = pixel & 0xFF; // Extraire la composante bleue
            int bit = (longueurMessage >> (31 - i)) & 1; // Extraire le bit de la longueur du message
            bleu = (bleu & 0xFE) | bit; // Modifier le bit de poids faible
            pixel = (pixel & 0xFFFFFF00) | bleu; // Mettre à jour la composante bleue
            image.setRGB(i % image.getWidth(), i / image.getWidth(), pixel); // Mettre à jour le pixel
        }

        // Ajouter le message dans le reste des pixels
        for (int i = 0; i < messageOctets.length * 8; i++) {
            int pixel = image.getRGB((i + 32) % image.getWidth(), (i + 32) / image.getWidth()); // Récupérer le pixel
            int bleu = pixel & 0xFF; // Extraire la composante bleue
            int bit = (messageOctets[i / 8] >> (7 - (i % 8))) & 1; // Extraire le bit du message
            bleu = (bleu & 0xFE) | bit; // Modifier le bit de poids faible
            pixel = (pixel & 0xFFFFFF00) | bleu; // Mettre à jour la composante bleue
            image.setRGB((i + 32) % image.getWidth(), (i + 32) / image.getWidth(), pixel); // Mettre à jour le pixel
        }

        // Créer le dossier imagesResultat s'il n'existe pas
        File dossierSortie = new File("imagesResult"); // Créer un objet File avec le nom du dossier
        if (!dossierSortie.exists()) { // Si le dossier n'existe pas
            dossierSortie.mkdirs(); // Créer le dossier
        }

        // Utiliser le nom du fichier d'origine pour le fichier de sortie
        String nomFichierOrigine = fichierEntree.getName(); // Récupérer le nom du fichier d'origine
        String nomFichierSortie =
                nomFichierOrigine.substring(0, nomFichierOrigine.lastIndexOf('.')) + "_cacher.png"; // Créer le nom
        File fichierSortie = new File(dossierSortie, nomFichierSortie); // Créer un objet File avec le chemin de sortie

        // Enregistrer l'image dans le dossier imagesResultat avec le nouveau nom
        ImageIO.write(image, "png", fichierSortie);
        System.out.println(
                "Message caché dans l'image avec succès dans " + fichierSortie.getAbsolutePath());
    }


    // Lire un message caché dans une image
    public static String lireMessage(String cheminFichier) throws Exception {
        File fichier = new File(cheminFichier); // Charger le fichier
        BufferedImage image = ImageIO.read(fichier); // Lire l'image en mémoire

        int longueurMessage = 0; // Longueur du message

        // Lire la longueur du message
        for (int i = 0; i < 32; i++) {
            int pixel = image.getRGB(i % image.getWidth(), i / image.getWidth()); // Récupérer le pixel
            int bleu = pixel & 0xFF; // Extraire la composante bleue
            longueurMessage = (longueurMessage << 1) | (bleu & 1); // Ajouter le bit de poids faible
        }

        // Vérification de la validité de la longueur du message
        if (longueurMessage < 0 || longueurMessage > image.getHeight() * image.getWidth() - 32) {
            throw new IllegalArgumentException(
                    "La longueur du message est invalide ou dépasse la taille de l'image.");
        }

        byte[] messageOctets = new byte[longueurMessage]; // Tableau d'octets pour le message

        // Lire le message
        for (int i = 0; i < longueurMessage * 8; i++) {
            int pixel = image.getRGB((i + 32) % image.getWidth(), (i + 32) / image.getWidth()); // Récupérer le pixel
            int bleu = pixel & 0xFF; // Extraire la composante bleue
            messageOctets[i / 8] = (byte) ((messageOctets[i / 8] << 1) | (bleu & 1)); // Ajouter le bit
        }

        return new String(messageOctets); // Retourner le message
    }

    // Utilisation de la méthode lireMessage
    public static void utiliserLireMessage(String cheminFichier) throws Exception {
        String message = lireMessage(cheminFichier);
        System.out.println("Message lu : " + message);
    }


    public static void utiliserCacherMessage(String fichierEntree, String message) throws Exception {
        Steganography.cacherMessage(fichierEntree, message);
    }
}
