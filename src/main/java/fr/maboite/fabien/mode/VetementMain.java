package fr.maboite.fabien.mode;

public class VetementMain {
	public static void main(String[] args) {
		Haut haut1 = new Haut("testHaut");
		Bas bas1 = new Bas("testBas", false);
		Client client1 = new Client("nom du client 1", "prenom du client 1", haut1, bas1);
		
		client1.parler();

	}
}
