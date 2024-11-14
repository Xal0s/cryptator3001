package aide;

public class RotaX {
    public static void afficherAideRotaX() {
        System.out.println(
                "On choisit une clé qui détermine de combien de lettres chaque caractère du message sera décalé. Par exemple, une clé de 3 signifie que chaque lettre du message sera remplacée par la lettre qui se trouve 3 positions plus loin dans l'alphabet.\n" +
                "On prend chaque lettre du message et on la remplace par la lettre qui se trouve à un certain nombre de positions après elle, selon la clé. Par exemple, avec une clé de 3 :\n" +
                "A devient D\n" +
                "B devient E\n" +
                "C devient F\n" +
                "Pour récupérer le message original, on effectue l'opération inverse : on décale chaque lettre de la clé en arrière dans l'alphabet.\n"
        );
        AideChiffrage.afficherAideChiffrage();
    }
}
