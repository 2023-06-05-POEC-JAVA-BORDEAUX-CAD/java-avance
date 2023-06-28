package fr.maboite.mode;

public class Client {
	private String nom;
	private String prenom;
	private Haut haut;
	private Bas bas;

	// CONSTRUCTOR

	public Client() {
		nom = "Mitchell";
		prenom = "Eddy";
		haut = new Haut();
		bas = new Bas();

	}

	public Client(String nom, String prenom, Haut haut, Bas bas) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.haut = haut;
		this.bas = bas;
	}

	// GETTERS AND SETTERS
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * // * @return the haut //
	 */
	public Haut getHaut() {
		return haut;
	}

	/**
	 * @param haut the haut to set
	 */
	public void setHaut(Haut haut) {
		this.haut = haut;
	}

	/**
	 * @return the bas
	 */
	public Bas getBas() {
		return bas;
	}

	/**
	 * @param bas the bas to set
	 */
	public void setBas(Bas bas) {
		this.bas = bas;
	}

	// METHODE DE CLASSE
	public void parle() {
		System.out.println(this.getPrenom() + " " + this.getNom() + " porte en bas " + bas.affiche() + " et en haut "
				+ haut.affiche() + ".");
	}

	public static Haut randomHaut() {

		// Choix du haut
		int j = (int) (Math.random() * 2);
		Haut haut = new Haut();
		switch (j) {
		case 0: {
			haut = new Chemise();
			break;
		}
		case 1: {
			haut = new Tshirt();
			break;
		}

		default:
			haut = new Tshirt();
		}

		return haut;
	}

	public static Bas randomBas() {
		// Choix du bas

		int i = (int) (Math.random() * 3);
		Bas bas = new Bas();
		switch (i) {
		case 0: {
			bas = new Pantalon();
			break;
		}
		case 1: {
			bas = new Jupe();
			break;
		}
		case 2: {
			bas = new Short();
			break;
		}
		default:
			bas = new Pantalon();
		}

		return bas;
	}

	public static void main(String[] args) {
		// Creation d'un client aléatoire.

		Client a = new Client("De Suza", "Linda", randomHaut(), randomBas());
		Client b = new Client("Joel", "Billy", randomHaut(), randomBas());
		a.parle();
		b.parle();

	}

}
