package fr.maboite.gabriel;

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ThreadHeritage thread1=new ThreadHeritage();
		 thread1.start();
		 
		 
		  ThreadRunnable threadUseRunnable=new ThreadRunnable();
		  
		// Création d'une instance de Thread 
		  Thread thread2=new Thread(threadUseRunnable);
		  
		  thread2.start();
		
		 while(true) {
		  System.out.println("Thread principal");
		  }
	}

}
