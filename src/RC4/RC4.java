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

        for (int i = 0; i < 256; i++) { // Initialisation de S
            S[i] = (byte) i; // Remplir S avec des valeurs de 0 à 255
        }

        int j = 0; // Indice j
        for (int i = 0; i < 256; i++) { // Permutation de S
            j = (j + S[i] + cle[i % longueurCle]) & 0xFF; // Calcul de j
            byte temp = S[i]; // Échange des valeurs de temp a partir de S
            S[i] = S[j]; // Échange des valeurs de S[i] a partir de S[j]
            S[j] = temp; // Échange des valeurs de S[j] a partir de temp
        }
    }

    // Générer un octet pseudo-aléatoire pour le flux
    private byte fluxOctetCle() {
        indiceI = (indiceI + 1) & 0xFF; // Calcul de i
        indiceJ = (indiceJ + S[indiceI]) & 0xFF; // Calcul de j

        byte temp = S[indiceI]; // Échange des valeurs de temp a partir de S
        S[indiceI] = S[indiceJ]; // Échange des valeurs de S[i] a partir de S[j]
        S[indiceJ] = temp; // Échange des valeurs de S[j] a partir de temp
        int somme = S[indiceI] + S[indiceJ]; // Calcule la somme des valeurs dans S aux positions indiceI et indiceJ.
                                             // S[indiceI] et S[indiceJ] sont des valeurs pseudo-aléatoires issues de la permutation S.
                                             // L'addition de ces deux valeurs sert à générer un nouvel index de manière difficile à prédire.

        int index = somme & 0xFF; // Applique un masque binaire pour restreindre la somme à 8 bits (0 à 255).
                                  // Le masque & 0xFF est utilisé pour s'assurer que le résultat reste dans la plage d'un octet,
                                  // même si la somme dépasse 255. Cela permet d'utiliser index comme un index valide dans le tableau S.

        byte resultat = S[index]; // Récupère la valeur dans S à la position index pour générer l'octet pseudo-aléatoire.
                                  // Cet octet extrait de S[index] est considéré comme un élément du flux pseudo-aléatoire généré
                                  // par l'algorithme, et sera utilisé pour le chiffrement.

        return resultat; // Retourne l'octet du flux pseudo-aléatoire
    }

    // Chiffre ou déchiffre un tableau de bytes
    public byte[] chiffrer(byte[] donnees) {
        byte[] resultat = new byte[donnees.length];  // Tableau de bytes pour le résultat

        for (int k = 0; k < donnees.length; k++) { // Chiffrement ou déchiffrement
            resultat[k] = (byte) (donnees[k] ^ fluxOctetCle()); // Chiffrement ou déchiffrement
        }

        return resultat;
    }

    public String  utilisationRC4(String texte, String cle) {
        // Convertir le texte et la clé en tableau de bytes
        byte[] texteBytes = texte.getBytes(); // Convertir le texte en tableau de bytes
        byte[] cleBytes = cle.getBytes(); // Convertir la clé en tableau de bytes

        // Créer une instance de RC4 avec la clé
        RC4 rc4 = new RC4(cleBytes); // Initialiser RC4 avec la clé

        byte[] texteChiffre = rc4.chiffrer(texteBytes); // Chiffrer le texte
        return new String(texteChiffre); // Retourner le texte chiffré

    }
}
