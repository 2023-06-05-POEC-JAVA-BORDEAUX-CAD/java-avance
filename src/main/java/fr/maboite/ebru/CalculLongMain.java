/**
 * 
 */
package fr.maboite.ebru;

/**
 * @author ebruj
 *
 */
public class CalculLongMain {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws InterruptedException {
		
		System.out.println("je lance le calcul long");
		
		
		
		CalculRennable calculLongRunnable = new CalculRennable();
		Thread threadCalculLong = new Thread(calculLongRunnable);
		
		
		threadCalculLong.start();
		threadCalculLong.join();

		System.out.println(calculLongRunnable.getVariable());
		
	

}
}
