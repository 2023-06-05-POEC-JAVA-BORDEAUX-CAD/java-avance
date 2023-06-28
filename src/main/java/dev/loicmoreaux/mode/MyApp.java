package dev.loicmoreaux.mode;

public class MyApp {

	public static void main(String[] args) {
	
		Haut haut1 = new Haut("Tshirt bleu");
		Bas bas1 = new Bas("jean noir", 85);
		Tshirt tshirt = new Tshirt("Tshirt noir");
		Client client1 = new Client("Doe", "John", haut1, bas1);
		
		Client client2 = new Client("Wake", "Alan", tshirt, bas1);
		
		client1.parle();
		client2.parle();
		
	}	
}
