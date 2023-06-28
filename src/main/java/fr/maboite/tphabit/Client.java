package fr.maboite.tphabit;

public class Client {
    private String nom;
    private String prenom;
    private Haut haut;
    private Bas bas;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Haut getHaut() {
        return haut;
    }

    public void setHaut(Haut haut) {
        this.haut = haut;
    }

    public Bas getBas() {
        return bas;
    }

    public void setBas(Bas bas) {
        this.bas = bas;
    }

    public void parle() {
        System.out.println("Client [nom=" + nom + ", prenom=" + prenom + "]");
        haut.affiche();
        bas.affiche();
    }
}