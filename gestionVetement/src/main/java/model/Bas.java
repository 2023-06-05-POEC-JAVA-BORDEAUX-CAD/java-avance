package model;

public class Bas implements Vetement {

	private String nom;
	private boolean longueur;
	
	
	@Override
	public String toString() {
		return "Bas [nom=" + nom + ", longueur=" + longueur + "]";
	}


	public Bas() {
		super();
	}


	public Bas(String nom, boolean longueur) {
		super();
		this.nom = nom;
		this.longueur = longueur;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public boolean isLongueur() {
		return longueur;
	}


	public void setLongueur(boolean longueur) {
		this.longueur = longueur;
	}


	public void afficher() {
System.out.println(this.toString());		
	}

}
