package fr.tdn;

import java.util.Scanner;

public class SaisieClav {

	static Scanner keyb = new Scanner(System.in);
	
		public static void main(String[] args) {
		
        int num = 0;

        System.out.println("Enter a number: ");

        num = keyb.nextInt();

        System.out.println("The number is : " + num);
    }

}