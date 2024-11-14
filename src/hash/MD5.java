package hash;

import menu.Menu;

import java.util.Scanner;

public class MD5 {
    public static void convertirEnMD5() {

        Scanner scanner = new Scanner(System.in);
        String entree = "";

        System.out.println("Entrez un message a hacher :");
        try{
            entree = scanner.nextLine();
        }catch(Exception e){
            System.out.println("Une erreur est survenue");
        }

        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(entree.getBytes("UTF-8"));
            StringBuilder chaineHexadecimale = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);

                if(hex.length() == 1) {
                    chaineHexadecimale.append('0');
                }
                chaineHexadecimale.append(hex);
            }

            System.out.println(chaineHexadecimale);
            Menu.afficherMenu();

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
