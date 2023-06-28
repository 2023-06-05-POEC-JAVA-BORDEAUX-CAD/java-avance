package fr.maboite.threads;

public class MyNewClassWithMultiThread {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main thread");
		MyNewThread nt = new MyNewThread("sec thread");
		nt.start();
		
		MyNewThreadRunnable ntr = new MyNewThreadRunnable();
		Thread ntrd = new Thread(ntr);
		ntrd.start();
		
		RunnableThreadSync rts = new RunnableThreadSync();
		rts.setA(10);
		rts.setB(20);
		
		Thread trts = new Thread(rts);
		trts.start();
		trts.join();
		System.out.println(rts.getRes());
		
		RunnableThreadSync rts2 = new RunnableThreadSync();
		rts2.setA(1);
		rts2.setB(20);
		
		Thread trts2 = new Thread(rts2);
		trts2.start();
		trts2.join();
		System.out.println(rts2.getRes());
		
		RunnableThreadSync rts3 = new RunnableThreadSync();
		rts3.setA(5);
		rts3.setB(20);
		
		Thread trts3 = new Thread(rts3);
		trts3.start();
		trts3.join();
		System.out.println(rts3.getRes());
		
	}
	
}
