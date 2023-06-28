package fr.maboite.gabriel;

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arg1 = "l";
		String arg2 = "m";

//		ThreadHeritage thread1 = new ThreadHeritage(arg1);
//		thread1.start();
//
//		ThreadRunnable threadUseRunnable = new ThreadRunnable(arg2);
//
//		// Création d'une instance de Thread
//		Thread thread2 = new Thread(threadUseRunnable);
//		thread2.start();
//		
//		
	

		//
		RandomRunnable thRun = new RandomRunnable();
		Thread th1 = new Thread(thRun);
		th1.start();

		try {
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("la valeur" +  thRun.getValeur());

		/*while (true) {
			System.out.println("Thread principal");
		}*/
	}

}
