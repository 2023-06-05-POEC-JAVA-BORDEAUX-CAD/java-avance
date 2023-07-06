package fr.maboite;

/**
 * Calcule des aires ...
 */
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
	public double aireRectangle(double longueurCoteA, double longueurCoteB) {
		return longueurCoteA * longueurCoteB;
	}
	
	/**
	 * Retourne l'aire d'un cercle de rayon r
	 * @param r
	 * @throws IllegalArgumentException si r est négatif
	 * @return
	 */
	public double aireCercle(double rayon) {
		if(rayon < 0) {
			throw new IllegalArgumentException("Impossible de calculer l'aire d'un cercle dont le rayon est négatif");
		}
		
		return Math.PI * rayon * rayon;
	}

	/**
	 * Retourne l'aire d'un triangle rectanble de base b et de hauteur h
	 * @param i
	 * @param j
	 * @return
	 */
	public double aireTriangleRectangle(double base, double hauteur) {
		return (base * hauteur)/2 ;
	}

}
