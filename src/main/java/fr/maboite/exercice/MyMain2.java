package fr.maboite.exercice;



public class MyMain2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Début du programme");
		
		MyRunnableClass2 myRunnable1 = new MyRunnableClass2();
		Thread thread1 = new Thread(myRunnable1);
		thread1.start();
		
		MyRunnableClass2 myRunnable2 = new MyRunnableClass2();
		Thread thread2 = new Thread(myRunnable2);
		thread2.start();
		
		MyRunnableClass2 myRunnable3 = new MyRunnableClass2();
		Thread thread3 = new Thread(myRunnable3);
		thread3.start();
		System.out.println("On attend que les threads bossent...");
		
		thread1.join();
		System.out.println(myRunnable1.getMessage());
		
		thread2.join();
		System.out.println(myRunnable2.getMessage());
		
		thread3.join();
		System.out.println(myRunnable3.getMessage());
		
		System.out.println("Fin du programme");
	}
}
