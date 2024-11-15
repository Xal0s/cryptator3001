package RC4;

import java.util.Arrays;

public class RC4 {

    private final byte[] S = new byte[256]; // Tableau S pour la permutation
    private int indiceI = 0; // Indice i
    private int indiceJ = 0; // Indice j

    // Constructeur pour initialiser RC4 avec une clé
    public RC4(byte[] cle) {
        initialiserS(cle); // Initialisation de la clé
    }

    // Initialisation du tableau S avec la clé
    private void initialiserS(byte[] cle) {
        int longueurCle = cle.length;

        for (int i = 0; i < 256; i++) {
            S[i] = (byte) i; // Remplir S avec des valeurs de 0 à 255
        }

        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + cle[i % longueurCle]) & 0xFF;
            byte temp = S[i];
            S[i] = S[j];
            S[j] = temp;
        }
    }

    // Générer un octet pseudo-aléatoire pour le flux
    private byte fluxOctetCle() {
        indiceI = (indiceI + 1) & 0xFF;
        indiceJ = (indiceJ + S[indiceI]) & 0xFF;

        byte temp = S[indiceI];
        S[indiceI] = S[indiceJ];
        S[indiceJ] = temp;

        return S[(S[indiceI] + S[indiceJ]) & 0xFF];
    }

    // Chiffre ou déchiffre un tableau de bytes
    private byte[] chiffrer(byte[] donnees) {
        byte[] resultat = new byte[donnees.length];
        for (int k = 0; k < donnees.length; k++) {
            resultat[k] = (byte) (donnees[k] ^ fluxOctetCle());
        }
        return resultat;
    }

    // Convertir une chaîne encodée en tableau de bytes
    private static byte[] parseByteArray(String arrayAsString) {
        String[] tokens = arrayAsString.replace("[", "").replace("]", "").split(", ");
        byte[] result = new byte[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Byte.parseByte(tokens[i]);
        }
        return result;
    }

    // Méthode à appeler pour chiffrer ou déchiffrer un texte
    public static String utilisationRC4(String texte, String cle) {
        if (texte == null || cle == null) {
            throw new IllegalArgumentException("Le texte et la clé ne doivent pas être null.");
        }

        byte[] texteBytes;
        if (texte.startsWith("[") && texte.endsWith("]")) {
            // Si le texte ressemble à un tableau d'octets encodé, le convertir
            texteBytes = parseByteArray(texte);
        } else {
            // Sinon, le considérer comme un texte brut
            texteBytes = texte.getBytes();
        }

        // Convertir la clé en tableau de bytes
        byte[] cleBytes = cle.getBytes();

        // Créer une instance de RC4 avec la clé
        RC4 rc4 = new RC4(cleBytes);

        // Chiffrer ou déchiffrer
        byte[] resultatBytes = rc4.chiffrer(texteBytes);

        // Tenter de convertir le résultat en texte lisible
        boolean isReadable = true;
        for (byte b : resultatBytes) {
            if (b < 32 || b > 126) { // Vérifie si ce sont des caractères imprimables ASCII
                isReadable = false;
                break;
            }
        }

        if (isReadable) {
            return new String(resultatBytes); // Retourner la chaîne lisible
        } else {
            return Arrays.toString(resultatBytes); // Sinon, retourner le tableau d'octets
        }
    }

}
