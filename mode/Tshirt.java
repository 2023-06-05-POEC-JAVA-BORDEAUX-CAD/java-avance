package fr.maboite.mode;

public class Tshirt extends Haut {
	String nom;

	public Tshirt() {

		String[] Tshirttab = { "un Tshirt bien stylé", "un Tshirt assez dégueulasse", "un Tshirt d'un goût douteux",
				"un Tshirt faisant honneur à la pétanque" };
		int i = (int) (Math.random() * Tshirttab.length);
		nom = Tshirttab[i];
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
