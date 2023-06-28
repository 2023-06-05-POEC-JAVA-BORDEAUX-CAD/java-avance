package fr.maboite.mode;

public class Pantalon extends Bas {
	private String nom;
	private Integer longueur;

	public Pantalon() {
		String[] Pantab = { "un futal en skaïe", "un slip 100% coton", "un blue jeans" };
		int i = (int) (Math.random() * Pantab.length);
		nom = Pantab[i];
		longueur = (int) (Math.random() * 25);
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

	public String affiche() {
		return (this.getNom() + " d'une longueur de " + this.getLongueur() + " cm");

	}

}
