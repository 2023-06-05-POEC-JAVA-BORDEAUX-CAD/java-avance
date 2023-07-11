package fr.maboite.cours.exception;

public class Garage {

	private boolean enFeu = true;

	private boolean inonde = false;

	private boolean deLEauPourArreterLIncendie = false;

	public Voiture getParNumeroImmatriculation(String numeroImmatriculation) throws Exception {
		if (enFeu) {
			try {
				tenteEteindreLIncendie();
			} catch (Exception exceptionDeLExtinctionDIncendie) {
				throw new Exception("Je suis en feu", exceptionDeLExtinctionDIncendie);
			}
			throw new Exception("je suis en feu.");
		}
		if (inonde) {
			throw new Exception("je suis inondé.");
		}
		if (numeroImmatriculation != null) {
			return new Voiture();
		}
		return null;
	}

	private void tenteEteindreLIncendie() throws Exception {
		System.out.println("Je lance de l'eau dans le circuit d'extinction...");
		if (!deLEauPourArreterLIncendie) {
			throw new Exception("Il n'y a plus d'eau pour arrêter l'incendie");
		}else {
			//plouf
			this.enFeu = false;
		}

	}

	/**
	 * Divise deux nombres positifs. Renvoie -1 si b == 0.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double calculeDivisionAParB(double a, double b) {
		if (b == 0) {
			return -1;
		}
		return a / b;
	}

	/**
	 * Divise deux nombres .
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double calculeDivisionAParBAvecException(double a, double b) throws Exception {
		if (b == 0) {
			Exception exception = new Exception("Attention, je ne sais pas diviser par zéro.");
			throw exception;
		}
		return a / b;
	}
	
	public void prepareDisque()  {
		positionneTeteDeLecture();
	}
	public void positionneTeteDeLecture()  {
		prepareFichier();
	}
	public void prepareFichier() {
		lanceLecriture();
	}
	public void lanceLecriture() {
		jecrisUnFichierSurleDisque();
	}
	
	/**
	 * Va foirer
	 * @throws Exception 
	 * @throws RuntimeException dans tous les cas
	 */
	public void jecrisUnFichierSurleDisque() throws RuntimeException {
		DiskException diskException = new DiskException();
		diskException.setDisqueEnEchec("42");
		throw diskException;
	}

}
