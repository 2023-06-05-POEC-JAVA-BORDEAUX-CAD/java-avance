package fr.maboite.cours.thread;

public class CalculLongRunnable implements Runnable {

	private int a;
	private int b;
	private int resultat;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3_000);			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		this.resultat = a + b;
	}

}
