package fr.maboite.servlet;

import jakarta.ejb.Stateless;

@Stateless
public class PojoDao {
	
	private String nom;
	private String prenom;
	
	public PojoDao() {
		super();
	}
	
		public PojoDao(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
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

	@Override
	public String toString() {
		return "PojoDao [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	

}
