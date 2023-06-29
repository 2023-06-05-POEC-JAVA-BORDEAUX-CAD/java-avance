package fr.maboite;

public class StringSum {

	public int compute(String str) {
		int result = 0;
		String[] tab = str.split(",");

		for (int i = 0; i < tab.length; i++) {

			if (tab[i] != "") {
				result += (Integer.valueOf(tab[i]));
			}
			System.out.println(tab[i]);
		}

		return result;
	}

}
