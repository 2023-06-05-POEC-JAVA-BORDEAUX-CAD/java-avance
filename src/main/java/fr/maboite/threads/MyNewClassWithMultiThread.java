package fr.maboite.threads;

public class MyNewClassWithMultiThread {

	public static void main(String[] args) {
		
		MyNewThread nt = new MyNewThread();
		nt.start();
		
		MyNewThreadRunnable ntr = new MyNewThreadRunnable();
		Thread ntrd = new Thread(ntr);
		ntrd.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("main thread");
		}
	}
	
}
