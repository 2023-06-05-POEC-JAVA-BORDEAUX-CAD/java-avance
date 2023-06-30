package fr.maboite;

public class Factorial {

	public Integer compute(int i) {
		// TODO Auto-generated method stub
		Integer result = 1;
		
		for(int j = 1; j <= i; j++) {
			result *= j;
		}
		
		return result;
	}

}
