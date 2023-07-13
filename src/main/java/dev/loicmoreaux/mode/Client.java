package dev.loicmoreaux.mode;

public class Client {
	/*
	 * Declaration attributes
	 */
	private String nom;
	private String prenom;
	private Haut haut;
	private Bas bas;
	
	/*
	 * Constructor
	 */
	public Client() {}
	
	public Client(String nom, String prenom, Haut haut, Bas bas) {
		this.nom = nom;
		this.prenom = prenom;
		this.haut = haut;
		this.bas = bas;
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
	
	public Haut getHaut() {
		return haut;
	}
	
	public Bas getBas() {
		return bas;
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
	
	public void setHaut(Haut haut) {
		this.haut = haut;
	}
	
	public void setBas(Bas bas) {
		this.bas = bas;
	}
	
	/*
	 * Methods
	 */
	public void parle() {
		System.out.println("Nom du client : " + this.getNom());
		System.out.println("Prénom du client : " + this.getPrenom());
		haut.affiche();
		bas.affiche();
	}
}