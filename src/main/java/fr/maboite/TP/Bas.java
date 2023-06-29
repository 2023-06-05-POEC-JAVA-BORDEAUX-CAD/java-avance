package fr.maboite.TP;

public class Bas implements Vetement{
	
	private String nom;
	private Boolean longueur;

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

	@Override
	public void affiche() {
		System.out.println("Nom du bas : " + nom);
		if(longueur)
		{
			System.out.println("Le bas est long.");
		}
		else
		{
			System.out.println("Le bas est court.");
		}
	}
	
	

}
