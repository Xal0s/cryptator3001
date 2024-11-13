package RC4;

public class RC4 {

    private byte[] S = new byte[256]; // Tableau S pour la permutation
    private int indiceI = 0; // Indice i
    private int indiceJ = 0; // Indice j

    // Constructeur pour initialiser RC4 avec une clé
    public RC4(byte[] cle) {
        initialiserS(cle); // Initialisation de la clé
    }

    // Initialisation du tableau S avec la clé
    private void initialiserS(byte[] cle) {
        int longueurCle = cle.length; // Longueur de la clé

        // Remplir S avec des valeurs de 0 à 255
        for (int i = 0; i < 256; i++) { // Initialisation de S
            S[i] = (byte) i; // Remplir S avec des valeurs de 0 à 255
        }

        // Permuter S en fonction de la clé
        int j = 0; // Indice j
        for (int i = 0; i < 256; i++) { // Permutation de S
            j = (j + S[i] + cle[i % longueurCle]) & 0xFF; // Calcul de j
            byte temp = S[i]; // Échange des valeurs de temp a partir de S
            S[i] = S[j]; // Échange des valeurs de S[i] a partir de S[j]
            S[j] = temp; // Échange des valeurs de S[j] a partir de temp
        }
    }

    // Générer un octet pseudo-aléatoire pour le flux
    private byte fluxOctetCle() { // Générer un octet pseudo-aléatoire
        indiceI = (indiceI + 1) & 0xFF; // Calcul de i
        indiceJ = (indiceJ + S[indiceI]) & 0xFF; // Calcul de j

        // Échange des valeurs dans S
        byte temp = S[indiceI]; // Échange des valeurs de temp a partir de S
        S[indiceI] = S[indiceJ]; // Échange des valeurs de S[i] a partir de S[j]
        S[indiceJ] = temp; // Échange des valeurs de S[j] a partir de temp

        // Retourne l'octet du flux pseudo-aléatoire
        return S[(S[indiceI] + S[indiceJ]) & 0xFF]; // Retourne l'octet du flux pseudo-aléatoire
    }

    // Chiffre ou déchiffre un tableau de bytes
    public byte[] chiffrer(byte[] donnees) {
        byte[] resultat = new byte[donnees.length];  // Tableau de bytes pour le résultat

        for (int k = 0; k < donnees.length; k++) { // Chiffrement ou déchiffrement
            resultat[k] = (byte) (donnees[k] ^ fluxOctetCle()); // Chiffrement ou déchiffrement
        }

        return resultat;
    }
}
