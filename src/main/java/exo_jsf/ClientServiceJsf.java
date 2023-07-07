package exo_jsf;


import jakarta.ejb.Stateless;

@Stateless
public class ClientServiceJsf {
	
	public void save(ClientFormBean client) {
		System.out.println("Je sauvegarde le client");
		System.out.println("id" + client.getId());
		System.out.println("companyName"+ client.getCompanyName());
	}

	
	public ClientFormBean load(Integer clientId) {
		ClientFormBean client = new ClientFormBean();
		client.setId(clientId);
		client.setCompannyName("la valeur de :" + clientId);
		return client;
	}



}