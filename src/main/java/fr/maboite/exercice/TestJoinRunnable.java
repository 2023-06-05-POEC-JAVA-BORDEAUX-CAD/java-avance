package fr.maboite.exercice;

public class TestJoinRunnable implements Runnable {
	// Variable d'instance
	private int x;
	
	// Getter
	public int getX(int x) {
		return this.x;
	};	
	
	@Override
	public void run() {
		
		this.x = 10;
		System.out.println("La valeur est " + x);
		
		try {
			Thread.sleep(5000);
			this.x = 50;
			System.out.println("La valeur est " + x);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}