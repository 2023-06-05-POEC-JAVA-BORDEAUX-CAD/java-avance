package fr.maboite.exercice;



	public class ThreadOne extends Thread {

		  @Override
		  public void run() {
			  while(true) {
		    System.out.println("ThreadOne");
			  }
		  }
	}
