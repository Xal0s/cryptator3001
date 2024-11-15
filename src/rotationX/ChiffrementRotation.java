package rotationX;

public class ChiffrementRotation {

    public static String chiffrementRotation(String message, int decalage) {
        StringBuilder messageChiffre = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ci = message.charAt(i);

            if (ci >= 'a' && ci <= 'z') {
                // Chiffrement pour les lettres minuscules
                char charChiffre = (char) (((ci - 'a' + decalage) % 26) + 'a');
                messageChiffre.append(charChiffre);
            } else if (ci >= 'A' && ci <= 'Z') {
                // Chiffrement pour les lettres majuscules
                char charChiffre = (char) (((ci - 'A' + decalage) % 26) + 'A');
                messageChiffre.append(charChiffre);
            } else {
                // Conserver les caractères non alphabétiques
                messageChiffre.append(ci);
            }
        }

        return messageChiffre.toString();
    }
}
