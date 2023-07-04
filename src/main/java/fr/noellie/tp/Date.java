package fr.noellie.tp;

public class Date {
	private Integer jour;
	private Integer mois;
	private Integer annee;

	// Constructeur vide
	public Date() {
	}

	// Constructeur avec attributs
	public Date(Integer jour, Integer mois, Integer annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	// Getters
	public Integer getJour() {
		return jour;
	}

	public Integer getMois() {
		return mois;
	}

	public Integer getAnnee() {
		return annee;
	}

	// Setters
	public void setJour(Integer jour) {
		this.jour = jour;
	}

	public void setMois(Integer mois) {
		this.mois = mois;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
}
