package fr.maboite;

public class Factorial {

	public Integer compute(int number) {
		if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * compute(number - 1);
        }
	}

}
