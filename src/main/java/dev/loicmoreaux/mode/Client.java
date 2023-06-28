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
	
	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

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
	
	/*
	 * Methods
	 */
	public void parle() {
		System.out.println("Nom du client : " + this.getNom());
		System.out.println("Prénom du client : " + this.getPrenom());
	}
}
