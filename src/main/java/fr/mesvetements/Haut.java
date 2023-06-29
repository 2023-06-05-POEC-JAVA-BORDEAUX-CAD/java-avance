package fr.mesvetements;

public class Haut implements IVetement {
	
	private String nom;
	
	public Haut() {}
	
	
	public Haut(String nom) {
		super();
		this.nom = nom;
	}


	public void affiche() {
		System.out.println(nom);
	}
	
	
	public String getNom() {
		
		return this.nom;
	}
	
	public void set (String nom) {
		 this.nom=nom;
	}

}
