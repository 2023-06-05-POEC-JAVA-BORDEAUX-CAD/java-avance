package fr.maboite.tp;

abstract class Bas implements Vetement {
	public String nom;
	public Integer longueur;
	
	//Constructeur
	public Bas(String nom, Integer longueur) {
		this.nom = nom;
		this.longueur = longueur;
	}
	
	//Getters
	public String getNom() {
		return this.nom;
	}
	
	public Integer getLongueur() {
		return this.longueur;
	}
	
	
	//Setters
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setLongueur(Integer longueur) {
		this.longueur = longueur;
	}
	
	//Méthode
	@Override
	public void affiche() {
		System.out.println("Habillé en bas");
	}	
}