package fr.maboite;

public class Factorial {

	public Integer compute(int input) {
		
		int i, fact = 1;
		
		for(i=1;i<=input;i++){    
		      fact=fact*i;    
		  }    
		
		return fact;
	}

}
