package Florian;

import jakarta.ejb.Stateless;

@Stateless
public class ClientService {
	
	public void save(ClientFormBean client) {
    	System.out.println("J'enregistre le client");
    	System.out.println("id: " + client.getId());
    	System.out.println("company name: " + client.getCompanyName());
    	System.out.println("first name: " + client.getFirstName());
    	System.out.println("last name: " + client.getLastName());
    	System.out.println("email: " + client.getEmail());
    	System.out.println("phone: " + client.getPhone());
    	System.out.println("adress: " + client.getAdress());
    	System.out.println("zipcode: " + client.getZipCode());
    	System.out.println("city: " + client.getCity());
    	System.out.println("country: " + client.getCountry());
    	System.out.println("state: " + client.getState());
    }
	
	public ClientFormBean load(Integer loadId){
		System.out.println("J'ai chargé le client avec l'id: " + loadId);
		ClientFormBean client = new ClientFormBean();
		client.setId(loadId);
		client.setCompanyName("Nom de la companie: " + loadId);
		client.setFirstName("Prenom : " + loadId);
		client.setLastName("Nom : " + loadId);
		client.setEmail("Email : " + loadId);
		client.setPhone("Téléphone : " + loadId);
		client.setAdress("Adresse : " + loadId);
		client.setZipCode("Code postal : " + loadId);
		client.setCity("Ville : " + loadId);
		client.setCountry("Pays : " + loadId);
		client.setState(loadId);
		return client;
	}
}
