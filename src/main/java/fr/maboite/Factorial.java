package fr.maboite;

public class Factorial {

	public Integer compute(int number) {
		if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * compute(number - 1);
        }
	}
	
	public static int countWords(String input) {
        int count = 0;
        // Parcours de chaque caractère dans la chaîne
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                count++;
            }
        }
        return count + 1;
    }

}
