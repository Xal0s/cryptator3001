package motDePasse;

import java.util.Scanner;

public class DemandeMotDePasse {
    public static String demandeMotDePasse() {
        System.out.println("Veuillez saisir un mot de passe que vous utiliserez dans l'application");
        Scanner scan = new Scanner(System.in);

        return scan.nextLine();
    }
}