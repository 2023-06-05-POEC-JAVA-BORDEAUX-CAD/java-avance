package dev.loicmoreaux.mode;

public class MyApp {

	public static void main(String[] args) {
	
		Haut haut1 = new Haut("Tshirt bleu");
		Bas bas1 = new Bas("jean noir", 85);
		Client client1 = new Client("Doe", "John", haut1, bas1);
		
		client1.parle();
		
	}	
}
