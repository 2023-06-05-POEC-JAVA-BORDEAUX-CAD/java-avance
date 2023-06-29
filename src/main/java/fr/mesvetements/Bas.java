package fr.mesvetements;

public class Bas implements IVetement {
	
	private String nom;
	private Boolean longueur;
	
	
	public Bas () {};
	
	public Bas(String nom, Boolean longueur) {
		super();
		this.nom = nom;
		this.longueur = longueur;
	}

	@Override
	 public void affiche() {
		System.out.println(nom);
	}
	
	
	public String getNom() {
		
		return this.nom;
	}
	
	public  Boolean getLongueur()
	{
		return this.longueur;
	}
	
	
	public void setNom( String nom) {
		this.nom=nom;
	}
	
	public void setLongueur(Boolean longueur) {
		
		this.longueur=longueur;
	}

}
