package fr.maboite;

public class Factorial {

	public Integer compute(int n) {
		// factorielle(n) = n * (n-1) * (n-2) * ... * 1

		if (n < 2) {
			return 1;
		}
		int produit = 1;
		for (int i = 2; i <= n; i++) {
			// produit = produit * i;
			produit *= i;
		}
		return produit;
	}
	
	public Integer computeRecursif(int n) {
		// factorielle(n) = n * (n-1) * (n-2) * ... * 1
		if (n < 2) {
			return 1;
		}
		return n * computeRecursif(n-1);
	}

}
