package vigenere;

public class ChiffrementVigenere {

    public static String chiffrementVigenere(String message, String cle) {
        StringBuilder messageChiffre = new StringBuilder();
        int indexCle = 0; // Indice pour parcourir la clé

        for (int i = 0; i < message.length(); i++) {
            char ci = message.charAt(i);

            if (Character.isLetter(ci)) { // Vérifie si le caractère est une lettre
                char ki = cle.charAt(indexCle % cle.length());

                if (Character.isUpperCase(ci)) {
                    // Chiffrement pour les lettres majuscules
                    char charChiffre = (char) (((ci - 'A' + (Character.toUpperCase(ki) - 'A')) % 26) + 'A');
                    messageChiffre.append(charChiffre);
                } else if (Character.isLowerCase(ci)) {
                    // Chiffrement pour les lettres minuscules
                    char charChiffre = (char) (((ci - 'a' + (Character.toLowerCase(ki) - 'a')) % 26) + 'a');
                    messageChiffre.append(charChiffre);
                }

                // Avancer dans la clé uniquement pour les caractères alphabétiques
                indexCle++;
            } else {
                // Conserver les caractères non alphabétiques
                messageChiffre.append(ci);
            }
        }

        return messageChiffre.toString();
    }
}
