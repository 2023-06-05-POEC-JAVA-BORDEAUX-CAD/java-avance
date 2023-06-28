package fr.maboite.tphabit;

public class Haut implements Vetement {
    String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void affiche() {
        System.out.println("Haut.affiche()");
    }
}
