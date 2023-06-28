package dev.loicmoreaux.mode;

public class Client {
	/*
	 * Declaration attributes
	 */
	private String nom;
	private String prenom;
	//private Haut haut;
	//private Bas bas;
	
	/*
	 * Constructor
	 */
	public Client() {}
	
	/*
	 * Getters
	 */
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	/*
	 * Setters
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
