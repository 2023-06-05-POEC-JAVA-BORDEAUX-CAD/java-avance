package fr.maboite;

public class CalculateurAire {
	
	/**
	 * Retourne l'aire d'un carré de côté cote
	 * @param cote
	 * @return
	 */
	public int aireCarre(int cote) {
		return cote * cote;
	}
	
	/**
	 * Retourne l'aire d'un rectangle dont les longeurs des côtés
	 * valent a et b
	 * @param a
	 * @param b
	 * @return
	 */
	public int aireRectangle(int longueurCoteA, int longueurCoteB) {
		return longueurCoteA * longueurCoteB;
	}

}
