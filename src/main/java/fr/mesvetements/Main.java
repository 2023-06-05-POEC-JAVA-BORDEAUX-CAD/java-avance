package fr.mesvetements;

public class Main {

	
	  public static void main(String[] args) {
	        Haut haut1 = new Haut("chemise");
	        Bas bas1 = new Bas("pantalon", true);
	        Client nouveauClient = new Client();
	        nouveauClient.setBas(bas1);
	        nouveauClient.setHaut(haut1);
	        
	        nouveauClient.getBas().affiche();
	  }

	
	
}
	
	
