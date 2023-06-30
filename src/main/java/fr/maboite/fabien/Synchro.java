package fr.maboite.fabien;

public class Synchro implements Runnable {
	private String infoTexte; // Variable d'instance

	public String getInfo() {
		return infoTexte;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000); 
			infoTexte = "coucou"; 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("pense à un mot ...");
		
		Synchro monRunnable = new Synchro();

		Thread thread = new Thread(monRunnable);
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String valeurDuRunnable = monRunnable.getInfo(); 
		System.out.println("Le mot est : " + valeurDuRunnable);
	}
}