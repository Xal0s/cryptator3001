package rotationX;

public class DechiffrementRotation {

    public static String dechiffrementRotation(String message, int decalage) {
        StringBuilder messageDeChiffre = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ci = message.charAt(i);

            if (ci >= 'a' && ci <= 'z') {
                // Déchiffrement pour les lettres minuscules
                char charDechiffre = (char) (((ci - 'a' - decalage + 26) % 26) + 'a');
                messageDeChiffre.append(charDechiffre);
            } else if (ci >= 'A' && ci <= 'Z') {
                // Déchiffrement pour les lettres majuscules
                char charDechiffre = (char) (((ci - 'A' - decalage + 26) % 26) + 'A');
                messageDeChiffre.append(charDechiffre);
            } else {
                // Conserver les caractères non alphabétiques
                messageDeChiffre.append(ci);
            }
        }

        return messageDeChiffre.toString();
    }
}
