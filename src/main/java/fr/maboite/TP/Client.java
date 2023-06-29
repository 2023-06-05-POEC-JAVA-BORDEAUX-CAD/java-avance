package fr.maboite.TP;

public class Client {
	
	private String nom;
	private String prenom;
	private Haut haut = new Haut();
	private Bas bas = new Bas();
	
	
	
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



	public void Parle()
	{
		haut.affiche();
		bas.affiche();
	}

}
