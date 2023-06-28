package fr.maboite.tp1;

public class ModeApp {

	public static void main(String[] args) {
		Client client = new Client();
		Trousers bottom = new Trousers();
		bottom.setName("trousers");
		bottom.setBotLenght(true);
		Tshirt tshirt = new Tshirt();
		tshirt.setName("tshirt");
		
		client.setTop(tshirt);
		client.setBottom(bottom);
		
		client.speak();
	}
	
}
