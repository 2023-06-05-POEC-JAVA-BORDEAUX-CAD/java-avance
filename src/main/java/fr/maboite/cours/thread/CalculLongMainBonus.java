package fr.maboite.cours.thread;

public class CalculLongMainBonus {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Je lance le calcul long");
		long start = System.currentTimeMillis();
		CalculLongRandomRunnable calculLongRunnable1 = new CalculLongRandomRunnable();
		calculLongRunnable1.setA(10);
		calculLongRunnable1.setB(5);
		Thread threadCalculLong1 = new Thread(calculLongRunnable1);
		threadCalculLong1.start();

		CalculLongRandomRunnable calculLongRunnable2 = new CalculLongRandomRunnable();
		calculLongRunnable2.setA(10);
		calculLongRunnable2.setB(10);
		Thread threadCalculLong2 = new Thread(calculLongRunnable2);
		threadCalculLong2.start();

		CalculLongRandomRunnable calculLongRunnable3 = new CalculLongRandomRunnable();
		calculLongRunnable3.setA(-4);
		calculLongRunnable3.setB(190);
		Thread threadCalculLong3 = new Thread(calculLongRunnable3);
		threadCalculLong3.start();
		
		
		threadCalculLong1.join();
		threadCalculLong2.join();
		threadCalculLong3.join();

		long end = System.currentTimeMillis();
		
		System.out.println("Les opérations ont pris : " + ((end - start)/1000));
		
		System.out.println("Le résultat du calcul 1 vaut : " + calculLongRunnable1.getResultat());
		System.out.println("Le résultat du calcul 2 vaut : " + calculLongRunnable2.getResultat());
		System.out.println("Le résultat du calcul 3 vaut : " + calculLongRunnable3.getResultat());
		
		System.out.println("Calcul long terminé");
		
	}

}
