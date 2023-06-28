package fr.maboite.gabriel;

public class ThreadHeritage extends  Thread  {

	  @Override
	    public void run() {
	        // Code exécuté dans le nouveau thread
		  while(true) {
	        System.out.println("Nouveau thread ");}
	    }
}
