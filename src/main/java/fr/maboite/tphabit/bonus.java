package fr.maboite.tphabit;

public class bonus {
    public static void main(String[] args) {
        Haut tshirt = new TShirt();
        tshirt.setNom("TSHIRT 1");

        Haut chemise = new Chemise();
        chemise.setNom("CHEMISE 1");

        Bas jupe = new Jupe();
        jupe.setNom("JUPE 1");
        jupe.setLongueur(true);

        Bas pantalon = new Pantalon();
        pantalon.setNom("PANTALON 1");
        pantalon.setLongueur(true);

        Client c1 = new Client();
        c1.setNom("LeNom");
        c1.setPrenom("LePrenom");
        c1.setHaut(tshirt);
        c1.setBas(jupe);

        Client c2 = new Client();
        c2.setNom("LeNom 2");
        c2.setPrenom("LePrenom 2");
        c2.setHaut(chemise);
        c2.setBas(pantalon);

        c1.parle();
        System.out.println("------");
        c2.parle();
    }
}