package Steganography;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Steganography {

    // Cacher un message dans une image
    public static void cacherMessage(File inputFile, String message) throws Exception {
        BufferedImage image = ImageIO.read(inputFile); // Lire l'image
        byte[] messageBytes = message.getBytes(); // Convertir le message en tableau de bytes
        int messageLength = messageBytes.length; // Longueur du message

        // Ajouter la longueur du message dans les premiers pixels
        for (int i = 0; i < 32; i++) {
            int pixel = image.getRGB(i % image.getWidth(), i / image.getWidth()); // Récupérer le pixel
            int blue = pixel & 0xFF; // Extraire la composante bleue
            int bit = (messageLength >> (31 - i)) & 1; // Extraire le bit de la longueur du message
            blue = (blue & 0xFE) | bit; // Modifier le bit de poids faible
            pixel = (pixel & 0xFFFFFF00) | blue; // Mettre à jour la composante bleue
            image.setRGB(i % image.getWidth(), i / image.getWidth(), pixel); // Mettre à jour le pixel
        }

        // Ajouter le message dans le reste des pixels
        for (int i = 0; i < messageBytes.length * 8; i++) {
            int pixel = image.getRGB((i + 32) % image.getWidth(), (i + 32) / image.getWidth()); // Récupérer le pixel
            int blue = pixel & 0xFF; // Extraire la composante bleue
            int bit = (messageBytes[i / 8] >> (7 - (i % 8))) & 1; // Extraire le bit du message
            blue = (blue & 0xFE) | bit; // Modifier le bit de poids faible
            pixel = (pixel & 0xFFFFFF00) | blue; // Mettre à jour la composante bleue
            image.setRGB((i + 32) % image.getWidth(), (i + 32) / image.getWidth(), pixel); // Mettre à jour le pixel
        }

        // Créer le dossier imagesResult s'il n'existe pas
        File outputDir = new File("imagesResult"); // Créer un objet File avec le nom du dossier
        if (!outputDir.exists()) { // Si le dossier n'existe pas
            outputDir.mkdirs(); // Créer le dossier
        }

        // Utiliser le nom du fichier d'origine pour le fichier de sortie
        String originalFileName = inputFile.getName(); // Récupérer le nom du fichier d'origine
        String outputFileName = originalFileName.substring(0, originalFileName.lastIndexOf('.')) + "_cacher.png"; // Créer le nom du fichier de sortie
        File outputFile = new File(outputDir, outputFileName); // Créer un objet File avec le nom du fichier de sortie

        // Enregistrer l'image dans le dossier imagesResult avec le nouveau nom
        ImageIO.write(image, "png", outputFile);
        System.out.println("Message caché dans l'image avec succès dans " + outputFile.getAbsolutePath()); // Afficher un message de succès
    }

    // Lire un message caché dans une image
    public static String lireMessage(BufferedImage image) {
        int messageLength = 0; // Longueur du message

        // Lire la longueur du message
        for (int i = 0; i < 32; i++) {
            int pixel = image.getRGB(i % image.getWidth(), i / image.getWidth()); // Récupérer le pixel
            int blue = pixel & 0xFF; // Extraire la composante bleue
            messageLength = (messageLength << 1) | (blue & 1);  // Ajouter le bit de poids faible à la longueur du message
        }

        // Vérification de la validité de la longueur du message
        if (messageLength < 0 || messageLength > image.getHeight() * image.getWidth() - 32) {
            throw new IllegalArgumentException("La longueur du message est invalide ou dépasse la taille de l'image.");
        }

        byte[] messageBytes = new byte[messageLength]; // Tableau de bytes pour le message

        // Lire le message
        for (int i = 0; i < messageLength * 8; i++) {
            int pixel = image.getRGB((i + 32) % image.getWidth(), (i + 32) / image.getWidth()); // Récupérer le pixel
            int blue = pixel & 0xFF; // Extraire la composante bleue
            messageBytes[i / 8] = (byte)((messageBytes[i / 8] << 1) | (blue & 1)); // Ajouter le bit de poids faible au message
        }

        return new String(messageBytes); // Retourner le message
    }

    public static void utiliserLireMessage (BufferedImage image) {
        String message = Steganography.lireMessage(image);
        System.out.println("Message lu : " + message);
    }

    public static void utiliserCacherMessage (File inputFile, String message) throws Exception {
        Steganography.cacherMessage(inputFile, message);
    }
}
