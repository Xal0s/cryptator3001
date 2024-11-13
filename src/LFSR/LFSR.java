package LFSR;

import java.util.Arrays;

public class LFSR {
    private final int[] taps;  // Positions des bits à XOR
    private int state;         // État actuel sous forme d'entier
    private final int mask;    // Masque pour limiter l'état aux bits significatifs

    // Constructeur privé pour éviter l'utilisation directe
    private LFSR(int[] taps, int initialState, int bitSize) {
        this.taps = taps;
        this.state = initialState & ((1 << bitSize) - 1); // Limite l'état initial au nombre de bits
        this.mask = (1 << bitSize) - 1; // Crée un masque pour maintenir l'état dans bitSize bits
    }

    // Effectue une étape et génère le prochain bit
    private int step() {
        int newBit = 0; // Nouveau bit à générer
        for (int tap : taps) { // Parcours les positions de taps
            newBit ^= (state >> tap) & 1; // XOR des bits aux positions taps
        }
        state = ((state >> 1) | (newBit << (Integer.SIZE - 1))) & mask; // Décale et limite aux bits
        return newBit;
    }

    // Génère un nombre de n bits
    private int generate(int n) {
        int result = 0; // Résultat final
        for (int i = 0; i < n; i++) { // Génère n bits
            result = (result << 1) | step(); // Décale et ajoute le nouveau bit
        }
        return result; // Retourne le nombre généré
    }

    // Méthode pour obtenir l'état actuel sous forme binaire
    private String getStateBinary(int bitSize) {
        return String.format("%" + bitSize + "s", Integer.toBinaryString(state)) // Convertit l'état en binaire
                .replace(' ', '0'); // Affiche l'état sous forme binaire
    }

    // Méthode statique pour exécuter le LFSR
    public static void runLFSR(int[] taps, int initialState, int bitSize, int steps, int bitsToGenerate) {
        LFSR lfsr = new LFSR(taps, initialState, bitSize); // Crée une instance de LFSR
        //System.out.println("État initial : " + lfsr.getStateBinary(bitSize)); // Affiche l'état initial

        // Exécute les étapes et affiche l'état
        for (int i = 0; i < steps; i++) {
            int bit = lfsr.step();  // Effectue une étape
            //System.out.println("Étape " + (i + 1) + " - Nouveau bit : " + bit); // Affiche le nouveau bit
            //System.out.println("État actuel : " + lfsr.getStateBinary(bitSize)); // Affiche l'état actuel
        }

        // Génère et affiche un nombre aléatoire de bits spécifié
        int randomValue = lfsr.generate(bitsToGenerate); // Génère un nombre aléatoire
        //System.out.println("Nombre aléatoire généré sur " + bitsToGenerate + " bits : " + randomValue); // Affiche le nombre généré
    }
}
