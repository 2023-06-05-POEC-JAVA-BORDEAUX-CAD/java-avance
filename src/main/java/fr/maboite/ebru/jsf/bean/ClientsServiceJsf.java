package fr.maboite.ebru.jsf.bean;

import jakarta.ejb.Stateless;

@Stateless
public class ClientsServiceJsf {
	
	
	public void save(ClientFormBean client) {
		System.out.println("je sauvegarde le client");
		System.out.println("id: " +client.getId());
		System.out.println("companyName: " + client.getCompanyName());
	}

	
	public ClientFormBean load(Integer ebruisthebest) {
		System.out.println("je charge le client avec l'id: " + ebruisthebest);
		ClientFormBean client = new ClientFormBean();
		client.setId(ebruisthebest);
		client.setCompanyName("la valeur de: " + ebruisthebest);
		return client;
		
	}
	
}
