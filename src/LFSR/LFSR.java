package LFSR;

import java.util.Arrays;

public class LFSR {
    private final int[] positionsXOR;  // Positions des bits à XOR
    private int etat;                  // État actuel sous forme d'entier
    private final int masque;          // Masque pour limiter l'état aux bits significatifs

    // Constructeur privé pour éviter l'utilisation directe
    private LFSR(int[] positionsXOR, int etatInitial, int tailleBits) {
        this.positionsXOR = positionsXOR;
        this.etat = etatInitial & ((1 << tailleBits) - 1); // Limite l'état initial au nombre de bits
        this.masque = (1 << tailleBits) - 1; // Crée un masque pour maintenir l'état dans le nombre de bits
    }

    // Effectue une étape et génère le prochain bit
    private int etape() {
        int nouveauBit = 0; // Nouveau bit à générer
        for (int position : positionsXOR) { // Parcours les positions de XOR
            nouveauBit ^= (etat >> position) & 1; // XOR des bits aux positions
        }
        etat = ((etat >> 1) | (nouveauBit << (Integer.SIZE - 1))) & masque; // Décale et limite aux bits
        return nouveauBit;
    }

    // Génère un nombre de n bits
    private int generer(int nombreBits) {
        int resultat = 0; // Résultat final
        for (int i = 0; i < nombreBits; i++) { // Génère n bits
            resultat = (resultat << 1) | etape(); // Décale et ajoute le nouveau bit
        }
        return resultat; // Retourne le nombre généré
    }

    // Méthode pour obtenir l'état actuel sous forme binaire
    private String obtenirEtatBinaire(int tailleBits) {
        return String.format("%" + tailleBits + "s", Integer.toBinaryString(etat)) // Convertit l'état en binaire
                .replace(' ', '0'); // Affiche l'état sous forme binaire
    }

    // Méthode statique pour exécuter le LFSR
    public static int executerLFSR(int[] positionsXOR, int etatInitial, int tailleBits, int nombreEtapes, int bitsAGenerer) {
        LFSR lfsr = new LFSR(positionsXOR, etatInitial, tailleBits); // Crée une instance de LFSR
        //System.out.println("État initial : " + lfsr.obtenirEtatBinaire(tailleBits)); // Affiche l'état initial

        // Exécute les étapes et affiche l'état
        for (int i = 0; i < nombreEtapes; i++) {
            int bit = lfsr.etape();  // Effectue une étape
            //System.out.println("Étape " + (i + 1) + " - Nouveau bit : " + bit); // Affiche le nouveau bit
            //System.out.println("État actuel : " + lfsr.obtenirEtatBinaire(tailleBits)); // Affiche l'état actuel
        }

        // Génère et affiche un nombre aléatoire de bits spécifié
        int valeurAleatoire = lfsr.generer(bitsAGenerer); // Génère un nombre aléatoire
        //System.out.println("Nombre aléatoire généré sur " + bitsAGenerer + " bits : " + valeurAleatoire); // Affiche le nombre généré

        return valeurAleatoire; // Retourne le nombre généré
    }
}
