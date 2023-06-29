/**
 * 
 */
package fr.boite.philippe.thread;

/**
 * 
 */
public class CalculMath {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Calcul long est lance");
		/*
		 * 
		 * 
		 */
		CalculMathRunnable calculMathRunnable = new CalculMathRunnable();
		calculMathRunnable.setA(20);
		calculMathRunnable.setB(15);

		Thread threadCalculLong = new Thread(calculMathRunnable);
		threadCalculLong.start();

		threadCalculLong.join();
		System.out.println("le resultat de calcul : " + calculMathRunnable.getResultat());
		System.out.println("Calcul long est termine");

	}

}
