package fr.maboite.correction.vetement;

public class Bas implements Vetement{

	private String nom;
	
	private boolean longueur;

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

	@Override
	public void affiche() {
		System.out.println("Un bas : " + nom + " " + (longueur? "long": "court"));
	}

}
