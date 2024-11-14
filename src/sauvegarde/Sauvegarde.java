package sauvegarde;

import java.io.File;
import java.io.FileWriter;

public class Sauvegarde {

    public static void SauvegardeMdp(String mdp) {

        String filePath = "mesMdps.txt";

        // Créer une instance de File pour vérifier l'existence
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                // Si le fichier n'existe pas on le créer
                file.createNewFile();
                System.out.println("Fichier créé : " + filePath);
            }

            // Maintenant que le fichier existe, on peut l'ouvrir en écriture
            FileWriter writer = new FileWriter(file, true); // 'true' pour ajouter au fichier
            writer.write(mdp + "\n");
            writer.close();

            System.out.println("Le mot de passe a été sauvegardé");

        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
    }
}

