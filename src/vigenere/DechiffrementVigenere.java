package vigenere;

public class DechiffrementVigenere {

    public static String dechiffrementVigenere(String message, String cle) {
        StringBuilder messageDeChiffre = new StringBuilder();
        int indexCle = 0; // Indice pour parcourir la clé

        for (int i = 0; i < message.length(); i++) {
            char ci = message.charAt(i);

            if (Character.isLetter(ci)) { // Vérifie si le caractère est une lettre
                char ki = cle.charAt(indexCle % cle.length());

                if (Character.isUpperCase(ci)) {
                    // Déchiffrement pour les lettres majuscules
                    char charDechiffre = (char) (((ci - 'A' - (Character.toUpperCase(ki) - 'A') + 26) % 26) + 'A');
                    messageDeChiffre.append(charDechiffre);
                } else if (Character.isLowerCase(ci)) {
                    // Déchiffrement pour les lettres minuscules
                    char charDechiffre = (char) (((ci - 'a' - (Character.toLowerCase(ki) - 'a') + 26) % 26) + 'a');
                    messageDeChiffre.append(charDechiffre);
                }

                // Avancer dans la clé uniquement pour les caractères alphabétiques
                indexCle++;
            } else {
                // Conserver les caractères non alphabétiques
                messageDeChiffre.append(ci);
            }
        }

        return messageDeChiffre.toString();
    }
}
