package fr.maboite.cours.thread;

public class MonRunnableQuiAfficheAuRevoir implements Runnable  {

	@Override
	public void run() {
		while(true) {
			System.out.println("Au revoir");
		}
	}


}
