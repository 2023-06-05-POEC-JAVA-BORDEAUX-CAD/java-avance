package fr.maboite.exercice;

public class Factorial {
	public Integer compute(int n) {
		// factorielle(n) = n * (n-1) * (n-2) * ... * 1

		if (n < 2) {
			return 1;
		}
		int produit = 1;
		for (int i = 1; i < n; i++) {
			produit *= i;
		}
		return produit;
	}
}
