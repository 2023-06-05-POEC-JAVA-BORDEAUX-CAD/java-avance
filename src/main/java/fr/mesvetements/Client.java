package fr.mesvetements;

public class Client {

	private String nom;
	private String prenom;
	private Haut haut;
	private Bas bas;

	Haut ht = new Haut();
	IVetement bs = new Bas();

	public void parle() {
		ht.affiche();
		bs.affiche();
	}
	
	
	

	public Client(Haut haut, Bas bas) {
		super();
		this.haut = haut;
		this.bas = bas;
	}


	public Client() {
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {

		return this.prenom;
	}

	public void setHaut(Haut haut) {
		this.haut = haut;
	}

	public void setBas(Bas bas) {
		this.bas = bas;
	}

	public Bas getBas() {
		return this.bas;
	}

	public Haut getHaut() {
		return this.haut;
	}

	public void setNom(String nom) {
		this.nom = nom;

	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
