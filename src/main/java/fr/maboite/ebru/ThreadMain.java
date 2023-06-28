/**
 * 
 */
package fr.maboite.ebru;

/**
 * @author ebruj
 *
 */
public class ThreadMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Ebru");
		System.out.println("et toi ?");

	MonThreadHey monThreadHey = new MonThreadHey();
	monThreadHey.start();
	
	MonThreadquiafficheAutre t= new MonThreadquiafficheAutre();
	Thread y=new Thread(t);
	y.start();
		
		while(true) {
			System.out.println("ThreadMain");
		}
		
		
	}

}
