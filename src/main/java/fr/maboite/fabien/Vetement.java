package fr.maboite.fabien;

public class Vetement {
    private String marque;
    private String type;
    private double prix;

    public Vetement(String nom, String type) {
        this.marque = nom;
        this.type = type;
    }

    public void affiche() {
        System.out.println("Marque : " + marque);
        System.out.println("Type : " + type);
    }

    public static void main(String[] args) {
        Vetement haut = new Vetement("Nike", "T-shirt");
        Vetement bas = new Vetement("Adidas", "Pantalon");

        Vetement pantalon = new Vetement("Levi's", "Pantalon");
        Vetement jupe = new Vetement("Zara", "Jupe");
        Vetement shortVetement = new Vetement("H&M", "Short");

        bas = pantalon; // Alimenter la variable bas avec l'objet pantalon

        haut.affiche();
        System.out.println("------------------------");
        bas.affiche();
    }
}
