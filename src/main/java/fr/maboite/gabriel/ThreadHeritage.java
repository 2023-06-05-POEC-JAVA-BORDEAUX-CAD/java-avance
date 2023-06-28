package fr.maboite.gabriel;

public class ThreadHeritage extends  Thread  {
	
	private String arg1;

	public ThreadHeritage(String arg1) {
		this.arg1=arg1;
		
	}
	  @Override
	    public void run() {
	        // Code exécuté dans le nouveau thread
		  while(true) {
	        System.out.println("Nouveau thread ");}
	    }
}
