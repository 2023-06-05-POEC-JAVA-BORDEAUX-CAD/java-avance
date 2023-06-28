package fr.maboite.mode;

public class Bas implements Vetement {
	private String nom;
	private Integer longueur;

	// COnstricteur

	public Bas() {
		nom = "un slip";
		longueur = 5;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the longueur
	 */
	public Integer getLongueur() {
		return longueur;
	}

	/**
	 * @param longueur the longueur to set
	 */
	public void setLongueur(Integer longueur) {
		this.longueur = longueur;
	}

	// Pour afficher le vêtement
	@Override
	public String affiche() {
		return (getNom() + " d'une longueur de " + getLongueur() + " cm");

	}

	public static void main(String[] args) {
		Bas a = new Bas();
		System.out.println(a.affiche());
	}
}