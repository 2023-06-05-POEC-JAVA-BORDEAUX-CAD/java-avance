/**
 * 
 */
package fr.maboite.ebru;

/**
 * @author ebruj
 *
 */
public class CalculRennable implements Runnable {

	private int x = 0;

	public void run() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		
		x=10;
	}

	public int getVariable() {
		return x;
	}

	public void setVariable(int x) {
		this.x = x;

	}

}
