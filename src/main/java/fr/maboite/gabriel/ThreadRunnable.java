package fr.maboite.gabriel;

public class ThreadRunnable implements Runnable {
	
	@Override
	public void run() {
		while(true) {
		System.out.println("thread utilisant runnable");
		}
	}

	

}
