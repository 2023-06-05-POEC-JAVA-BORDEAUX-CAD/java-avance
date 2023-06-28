package fr.maboite.mode;

public class Jupe extends Bas {
	private String nom;
	private Integer longueur;

	public Jupe() {
		String[] Jupetab = { "une jupe digne de Beyonce", "une jupe de majorette", "un shorty" };
		int i = (int) (Math.random() * Jupetab.length);
		nom = Jupetab[i];
		longueur = (int) (Math.random() * 25);
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	public Integer getLongueur() {
		return longueur;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String affiche() {
		return (this.getNom() + " d'une longueur de " + this.getLongueur() + " cm");
	}
}
