package dev.loicmoreaux.mode;

public class Bas implements Vetement{
	private String nom;
	private Integer longueur;
	
	/*
	 * Constructor
	 */
	public Bas() {}
	
	public Bas(String nom, Integer longueur) {
		this.nom = nom;
		this.longueur = longueur;
	}
	
	/*
	 * Getters
	 */
	public String getNom() {
		return nom;
	}

	public Integer getLongueur() {
		return longueur;
	}

	/*
	 * Setters
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setLongueur(Integer longueur) {
		this.longueur = longueur;
	}

	@Override
	public void affiche() {
		// TODO Auto-generated method stub
		System.out.println("Je suis un Bas");
		
	}
	
}
