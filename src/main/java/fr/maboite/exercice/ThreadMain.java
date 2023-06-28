package fr.maboite.exercice;

public class ThreadMain {

		  public static void main(String[] args) {
			  			 
				  ThreadOne t = new ThreadOne();
				  t.start();

				  Thread thread = new Thread(new ThreadTwo());
				  thread.start();
				  
				  while(true) {
					  System.out.println("ThreadMain");
				  }			  
		  }
}
