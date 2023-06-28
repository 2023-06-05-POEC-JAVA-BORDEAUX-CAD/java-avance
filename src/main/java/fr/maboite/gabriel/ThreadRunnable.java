package fr.maboite.gabriel;

public class ThreadRunnable implements Runnable {
	
	private String arg2;
	
	public ThreadRunnable(String arg2) {
		this.arg2=arg2;
	}
	@Override
	public void run() {
		while(true) {
		System.out.println("thread utilisant runnable");
		}
	}

	

}
