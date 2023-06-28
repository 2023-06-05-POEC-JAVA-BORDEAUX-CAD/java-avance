/**
 * 
 */
package fr.boite.philippe.thread;

/**
 * 
 */
public class CalculMathRunnable implements Runnable {
	private int a;
	private int b;
	private int resultat;

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getResultat() {
		return resultat;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.resultat = a + b;
	}

	public void setA(int a) {
		// TODO Auto-generated method stub
		this.a = a;
	}

	public void setB(int b) {
		// TODO Auto-generated method stub
		this.b = b;
	}
}
