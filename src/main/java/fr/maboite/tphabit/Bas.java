package fr.maboite.tphabit;

public class Bas implements Vetement {
    String nom;
    Boolean longueur;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getLongueur() {
        return longueur;
    }

    public void setLongueur(Boolean longueur) {
        this.longueur = longueur;
    }

    public void affiche() {
        System.out.println("Bas [nom=" + nom + ", longueur=" + longueur + "]");
    }
}
