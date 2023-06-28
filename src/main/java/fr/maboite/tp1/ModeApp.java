package fr.maboite.tp1;

public class ModeApp {

	public static void main(String[] args) {
		Client client = new Client();
		Trousers bottom = new Trousers();
		bottom.setName("trousers");
		bottom.setBotLenght(true);
		bottom.display();
		Tshirt tshirt = new Tshirt();
		tshirt.setName("tshirt");
		tshirt.display();
		
		client.setTop(tshirt);
		client.setBottom(bottom);
		
		client.speak();
	}
	
}
