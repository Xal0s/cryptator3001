package aide;

public class Enigma {
    public static String afficherAideEnigma(String mdp) {
        System.out.println("\n" +
                "Enigma utilise plusieurs rotors (disques circulaires) sur lesquels les lettres de l'alphabet sont inscrites.\n " +
                "Les rotors tournent à chaque frappe de touche, changeant ainsi le schéma de substitution à chaque lettre.\n" +
                "La clé de chiffrement est déterminée par :\n" +
                "- Le nombre et l'ordre des rotors utilisés.\n" +
                "- La position initiale des rotors.\n" +
                "- Le réglage des réflecteurs et des câblages internes.\n" +
                "Par exemple, un message peut commencer avec les rotors dans une position donnée, mais à chaque touche pressée, un rotor tourne et modifie le chiffrement.\n" +
                "Lorsqu'une lettre est pressée, elle passe par un processus complexe où elle est remplacée par une autre lettre. Le signal passe à travers chaque rotor, puis se réfléchit et repasse à travers les rotors dans un sens inverse. Finalement, une lampe s'allume pour indiquer la lettre chiffrée correspondante.\n" +
                "Le processus de déchiffrement est le même que le chiffrement. Le destinataire doit connaître la clé (les positions des rotors et les réglages) pour pouvoir inverser le chiffrement\n"
        );

        return mdp;
    }

}
