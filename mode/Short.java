package fr.maboite.mode;

public class Short extends Bas {
	private String nom;
	private Integer longueur;

	public Short() {
		String[] Shorttab = { "un short de volley ultracourt", "un pantalon cargo", "un bermuda", "un sarouel" };
		int i = (int) (Math.random() * Shorttab.length);
		nom = Shorttab[i];
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
