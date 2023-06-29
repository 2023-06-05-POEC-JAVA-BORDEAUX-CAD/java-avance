package fr.maboite.cours.thread;

import java.util.Random;

public class CalculLongRandomRunnable implements Runnable {

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
			Thread.sleep((new Random().nextInt(9) + 1) * 1_000 );			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		this.resultat = a + b;
	}

}
