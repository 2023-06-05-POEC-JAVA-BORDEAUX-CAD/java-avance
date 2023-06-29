package model;

public class Client {
	private String nom;
	private String prenom;
	private Haut haut;
	private Bas bas;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Haut getHaut() {
		return haut;
	}

	public void setHaut(Haut haut) {
		this.haut = haut;
	}

	public Bas getBas() {
		return bas;
	}

	public void setBas(Bas bas) {
		this.bas = bas;
	}

	public Client() {
		super();
	}

	public Client(String nom, String prenom, Haut haut, Bas bas) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.haut = haut;
		this.bas = bas;
	}

	public void parler() {
		System.out.println("wahou je parle");
		this.haut.afficher();
		this.bas.afficher();
	}
}
