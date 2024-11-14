package hash;

public class MD5 {
    public static String convertirEnMD5(String entree) {
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

            return chaineHexadecimale.toString();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
