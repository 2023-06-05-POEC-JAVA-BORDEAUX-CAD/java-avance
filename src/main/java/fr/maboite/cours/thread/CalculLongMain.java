package fr.maboite.cours.thread;

public class CalculLongMain {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Je lance le calcul long");
		CalculLongRunnable calculLongRunnable = new CalculLongRunnable();
		calculLongRunnable.setA(10);
		calculLongRunnable.setB(5);
		
		Thread threadCalculLong = new Thread(calculLongRunnable);
		threadCalculLong.start();
		
		threadCalculLong.join();
		System.out.println("Le résultat du calcul vaut : " + calculLongRunnable.getResultat());
		
		System.out.println("Calcul long terminé");
		
	}

}
