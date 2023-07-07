package fr.boite.philippe.jsf.service;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;



@Stateless
public class ClientService {

	public void save(ClientFaceBeanTp client) {
		System.out.println("je sauvegarde le client");
		System.out.println("je sauvegarde le client : " + client);
	}
	
	public Client load(Integer id) {
	
		return null;
	}
}