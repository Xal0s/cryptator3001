import menu.Menu;
import motDePasse.DemandeMotDePasse;

public class Main {
    public static void main(String[] args) {

        String mdp = "";

        System.out.println(
            "****************************\n" +
            "**Bienvenue sur PaKassable**\n" +
            "****************************\n"
        );

        mdp = DemandeMotDePasse.demandeMotDePasse();

        Menu.afficherMenu(mdp);

    }
}