package fr.maboite.ebru;

public class Haut implements Vetements{
	
	
	private String nom;
	
	
	public Haut(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public void affiche() {
		
	System.out.println("haut" + nom);
	}
		
}