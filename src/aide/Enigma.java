package aide;

public class Enigma {
    public static String afficherAideEnigma(String mdp) {
        System.out.println(
                """

                        Enigma utilise plusieurs rotors (disques circulaires) sur lesquels les lettres de l'alphabet sont inscrites.
                         Les rotors tournent \u00e0 chaque frappe de touche, changeant ainsi le sch\u00e9ma de substitution \u00e0 chaque lettre.
                        La cl\u00e9 de chiffrement est d\u00e9termin\u00e9e par :
                        - Le nombre et l'ordre des rotors utilis\u00e9s.
                        - La position initiale des rotors.
                        - Le r\u00e9glage des r\u00e9flecteurs et des c\u00e2blages internes.
                        Par exemple, un message peut commencer avec les rotors dans une position donn\u00e9e, mais \u00e0 chaque touche press\u00e9e, un rotor tourne et modifie le chiffrement.
                        Lorsqu'une lettre est press\u00e9e, elle passe par un processus complexe o\u00f9 elle est remplac\u00e9e par une autre lettre. Le signal passe \u00e0 travers chaque rotor, puis se r\u00e9fl\u00e9chit et repasse \u00e0 travers les rotors dans un sens inverse. Finalement, une lampe s'allume pour indiquer la lettre chiffr\u00e9e correspondante.
                        Le processus de d\u00e9chiffrement est le m\u00eame que le chiffrement. Le destinataire doit conna\u00eetre la cl\u00e9 (les positions des rotors et les r\u00e9glages) pour pouvoir inverser le chiffrement
                        """);

        return mdp;
    }

}
