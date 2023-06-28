package fr.maboite.exercice;



	public class ThreadTwo implements Runnable {

		  @Override
		  public void run(){
			  while(true) {
		    System.out.println("ThreadTwo");
			  }
		  }
	}