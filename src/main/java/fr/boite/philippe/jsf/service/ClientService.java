package fr.boite.philippe.jsf.service;
import fr.boite.philippe.jsf.controller.ClientFormBean;
import jakarta.ejb.Stateless;


@Stateless
public class ClientService {

	public void save(ClientFormBean client) {
		System.out.println("je sauvegarde le client");
		System.out.println("id Client : " + client.getClientId());
		System.out.println("companyName : " + client.getCompanyName());
		System.out.println("FirstName : " + client.getFirstName());
		System.out.println("lastName : " + client.getLastName());
		System.out.println("Email : " + client.getEmail());
		System.out.println("Address : " + client.getAddress());
		System.out.println("ZipCode : " + client.getZipCode());
		System.out.println("Country : " + client.getCountry());
		System.out.println("ClientState : " + client.getClientState());
		
	}
	
	public ClientFormBean load(Integer loadId) {
		System.out.println("je charge le client avec son id : " + loadId);
		ClientFormBean client = new ClientFormBean();
		client.setClientId(loadId);
		client.setCompanyName("Nome de la compagnie : " + loadId);
		client.setFirstName("FirstName : " + loadId);
		client.setLastName("LastName : " + loadId);
		client.setEmail("Email : " + loadId);
		client.setAddress("Address : " + loadId);
		client.setZipCode("ZipCode : " + loadId);
		client.setCountry("Country : " + loadId);
		return client;
	}
}