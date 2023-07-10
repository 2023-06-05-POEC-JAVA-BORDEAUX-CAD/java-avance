package fr.tdn;

import java.util.Scanner;

public class TpCalc {

		static Scanner keyb = new Scanner(System.in);
		
			public static void main(String[] args) {
			
	        int num1 = 0, num2 = 0;

	        System.out.println("Enter le number 1 : ");
	        num1 = keyb.nextInt();
	        
	        System.out.println("Enter le number 2 : ");
	        num2 = keyb.nextInt();

	        System.out.println("La somme de " + num1 + " et " + num2 + " est = " + (num1 + num2));
	        System.out.println("La différence de " + num1 + " et " + num2 + " est = " + (num1 - num2));
	        System.out.println("Le produit de " + num1 + " et " + num2 + " est = " + (num1 * num2));

	    }

	}