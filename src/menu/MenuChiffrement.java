package menu;

import RC4.RC4;
import aide.Aide;
import polybe.Polybe;
import rotationX.ChiffrementRotation;
import vigenere.ChiffrementVigenere;

import java.util.Scanner;

public class MenuChiffrement {
    public static void afficherMenuChiffrement(){
        boolean choix = true;
        while (choix) {

            System.out.println(
                    "Quel algorithme voulez-vous utiliser ? :\n" +
                    "1 - Rotation(x) \n" +
                    "2 - Vigenère\n" +
                    "3 - RC4\n" +
                    "4 - Carré de Polybe\n" +
                    "5 - Enigma\n" +
                    "6 - Avoir de l'aide" +
                    "7 - Quitter"
            );

            Scanner scan = new Scanner(System.in);
            try{
                switch (scan.nextInt()) {
                    case 1:
                        choix = false;
                        ChiffrementRotation.chiffrementRotation();
                        break;
                    case 2:
                        choix = false;
                        ChiffrementVigenere.chiffrementVigenere();
                        break;
                    case 3:
                        choix = false;
                        RC4.utilisationRC4();
                        break;
                    case 4 :
                        choix = false;
                        Polybe.chiffrer();
                        break;
                    case 5:
                        choix = false;
                        System.out.println("C'est pas prêt");
                        break;
                    case 6:
                        choix = false;
                        Aide.afficherAide();
                        break;
                    case 7:
                        System.exit(0);
                    default: System.out.println("\nVotre choix n'est pas disponible\n");
                }
            }catch(Exception e){
                System.out.println("\nVeuillez entrer un chiffre valide\n");
            }
        }
    }
}
