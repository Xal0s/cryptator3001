package utils;

public class ConsoleColor {

    // Codes ANSI pour les couleurs
    public static final String RESET = "\033[0m"; // Réinitialise la couleur

    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    // Codes ANSI pour les couleurs en gras
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String WHITE_BOLD = "\033[1;37m";

    /**
     * Applique une couleur à un texte donné.
     *
     * @param colorCode Le code couleur ANSI à appliquer
     * @param message Le message à colorier
     * @return Le message avec le code couleur appliqué
     */
    public static String colorize(String colorCode, String message) {
        return colorCode + message + RESET;
    }

    // Méthode de test
    public static void test(String[] args) {
        System.out.println(ConsoleColor.colorize(ConsoleColor.RED, "Texte en rouge"));
        System.out.println(ConsoleColor.colorize(ConsoleColor.GREEN, "Texte en vert"));
        System.out.println(ConsoleColor.colorize(ConsoleColor.BLUE, "Texte en bleu"));
        System.out.println(ConsoleColor.colorize(ConsoleColor.BLUE_BOLD, "Texte en bleu gras"));
    }
}
