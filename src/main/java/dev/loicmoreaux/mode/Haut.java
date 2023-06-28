package dev.loicmoreaux.mode;

public class Haut implements Vetement {
	/*
	 * Declaration attributes
	 */
	private String nom;
	
	/*
	 * Constructor
	 */
	public Haut() {	}
	
	public Haut(String nom) {
		super();
		this.nom = nom;
	}

	/*
	 * Getters
	 */
	public String getNom() {
		return nom;
	}
	
	/*
	 * Setters
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void affiche() {
		// TODO Auto-generated method stub
		
	}
	
}
