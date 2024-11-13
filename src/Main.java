import LFSR.LFSR;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Appel unique de runLFSR pour exécuter et afficher les étapes
        LFSR.runLFSR(
                new int[]{0, 2}, // Positions de taps pour le XOR
                0b10011001,          // État initial en binaire
                8,               // Taille du registre (4 bits)
                15,               // Nombre d'étapes à exécuter
                8                // Nombre de bits à générer
        );
    }
}