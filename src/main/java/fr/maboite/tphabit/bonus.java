package fr.maboite.tphabit;

public class bonus {
    public static void main(String[] args) {
        Haut tshirt = new TShirt();
        tshirt.setNom("TSHIRT 1");

        Bas jupe = new Jupe();
        jupe.setNom("JUPE 1");
        jupe.setLongueur(true);

        Client c1 = new Client();
        c1.setNom("LeNom");
        c1.setPrenom("LePrenom");
        c1.setHaut(tshirt);
        c1.setBas(jupe);

        c1.parle();
    }
}