package fr.maboite.TP;

public class Main {

	public static void main(String[] args) {

		Client client1 = new Client();
		Haut haut1 = new Haut();
		Bas bas1 = new Bas();
		
		//Attribut des valeurs aux attributs de haut1 et bas1
		
		haut1.setNom("Chemise");
		
		bas1.setNom("Pentalon");
		bas1.setLongueur(true);
		
		
		//Attribut des valeurs aux attributs de client1
		
		client1.setNom("Moinet");
		client1.setPrenom("Simon");
		client1.setBas(bas1);
		client1.setHaut(haut1);
		
		System.out.println(client1.getNom());
		System.out.println(client1.getPrenom());
		client1.Parle();
		
	}

}
