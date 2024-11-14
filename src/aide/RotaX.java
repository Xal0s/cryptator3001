package aide;

public class RotaX {
    public static String afficherAideRotaX(String mdp) {
        System.out.println(
                """
                        On choisit une cl\u00e9 qui d\u00e9termine de combien de lettres chaque caract\u00e8re du message sera d\u00e9cal\u00e9. Par exemple, une cl\u00e9 de 3 signifie que chaque lettre du message sera remplac\u00e9e par la lettre qui se trouve 3 positions plus loin dans l'alphabet.
                        On prend chaque lettre du message et on la remplace par la lettre qui se trouve \u00e0 un certain nombre de positions apr\u00e8s elle, selon la cl\u00e9. Par exemple, avec une cl\u00e9 de 3 :
                        A devient D
                        B devient E
                        C devient F
                        Pour r\u00e9cup\u00e9rer le message original, on effectue l'op\u00e9ration inverse : on d\u00e9cale chaque lettre de la cl\u00e9 en arri\u00e8re dans l'alphabet.
                        """);
        return mdp;
    }
}
