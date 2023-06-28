/**
 * 
 */
package fr.boite.philippe;

/**
 * 
 */
public class ThreadMain {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bonjour");
		System.out.println("comment ça va");
		System.out.println("bien");
		System.out.println("au revoir");
		
		
		MonTheardAfficheBonjou MonTheardAfficheBonjou = new MonTheardAfficheBonjou();
		MonTheardAfficheBonjou.start();
		

		//un nouveau Thread
		MonTheardAfficheAurevoir MonTheardAfficheAurevoir = new MonTheardAfficheAurevoir();
		Thread threadAvecRunnable = new Thread(MonTheardAfficheAurevoir);
		threadAvecRunnable.start();
		
		while(true) {
			System.out.println("Thead main");
		}
	}

}
