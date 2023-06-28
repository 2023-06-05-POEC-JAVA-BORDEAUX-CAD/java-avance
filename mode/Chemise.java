package fr.maboite.mode;

public class Chemise extends Haut {
	String nom;

	public Chemise() {

		String[] Chemisetab = { "une chemisette à fleurs", "un col roulé en laine", "un marcel troué", "un polo" };
		int i = (int) (Math.random() * Chemisetab.length);
		nom = Chemisetab[i];
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

	public String affiche() {
		return this.getNom();
	}
}
