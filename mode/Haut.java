package fr.maboite.mode;

public class Haut implements Vetement {

	private String nom;
	// CONSTRUCTEUR

	public Haut() {
		nom = "un bolero";
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

	// Pour afficher le vêtement
	@Override
	public String affiche() {
		return getNom();

	}

	public static void main(String[] args) {
		Haut h = new Haut();
		System.out.println(h.affiche());
	}
}
