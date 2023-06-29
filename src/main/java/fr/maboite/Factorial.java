package fr.maboite;

public class Factorial {

	public Integer compute(int i) {
		// TODO Auto-generated method stub
		Integer result = 1;
		
		if(i <= 1) return result;
		
		for(int j = 1; j <= i; j++) {
			result *= j;
		}
		
		return result;
	}

}
