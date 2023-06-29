package fr.maboite.ebru;

public class Bas {
	
	
	private String nom;
	private Boolean longueur; 
	
	
	public Bas(String nom, Boolean longueur) {
		this.nom = nom;
		this.longueur = longueur;
	}

	
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
		
		System.out.println("Bas" + nom);
		
		System.out.println("Bas" + longueur);
		
		
		}

}
