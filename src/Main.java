import menu.Menu;
import motDePasse.DemandeMotDePasse;

public class Main {
    public static void main(String[] args) {

        String mdp = "";

        System.out.println("""
                ****************************
                **Bienvenue sur PaKassable**
                ****************************
                """);

        mdp = DemandeMotDePasse.demandeMotDePasse();

        Menu.afficherMenu(mdp);

    }
}
