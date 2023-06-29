package main;

import model.Bas;
import model.Client;
import model.Haut;

public class VetementMain {

	public static void main(String[] args) {
		Haut haut1 = new Haut("testHaut");
		Bas bas1= new Bas("testBas",false);
		Client client1 = new Client("nomclient1","prenomclient1",haut1,bas1);
		
		client1.parler();

	}

}
