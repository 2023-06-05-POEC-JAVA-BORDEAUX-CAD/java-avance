package fr.maboite.tp;

abstract class Haut implements Vetement {
	public String nom;
	
	//Constructeur
	public Haut(String nom) {
		this.nom = nom;
	}
	
	//Getters
	public String getNom() {
		return this.nom;
	}
	
	//Setters
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//Méthode
	@Override
	public void affiche() {
		System.out.println("Habillé en haut");
	}	
}