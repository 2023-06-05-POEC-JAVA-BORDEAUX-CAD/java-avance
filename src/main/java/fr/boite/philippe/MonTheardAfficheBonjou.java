/**
 * 
 */
package fr.boite.philippe;

/**
 * 
 */
public class MonTheardAfficheBonjou extends Thread {

	/**
	 * @param args
	 */
	
	public void run() {
		while(true) {
			System.out.println("Bonjour");
		}
	}
}
