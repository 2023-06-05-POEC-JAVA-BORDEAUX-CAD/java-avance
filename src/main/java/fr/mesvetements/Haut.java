package fr.mesvetements;
public class Haut implements Vetement {

	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void affiche() {
		System.out.println("un haut : " + nom);
	}

}
