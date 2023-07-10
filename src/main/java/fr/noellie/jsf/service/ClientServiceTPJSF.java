package fr.noellie.jsf.service;

import fr.noellie.jsf.controller.ClientFormBean;
import jakarta.ejb.Stateless;

@Stateless
public class ClientServiceTPJSF {
	public void save(ClientFormBean client) {
		System.out.println("Je sauvegarde le client");
		System.out.println("id: " + client.getId());
		System.out.println("company name: " + client.getCompanyName());
		
	}

	public ClientFormBean load(Integer loadId) {
		System.out.println("Je charge le client avec l'id: " + loadId);
		ClientFormBean client = new ClientFormBean();
		client.setId(loadId);
		client.setCompanyName("Le nom de l'entreprise : " + loadId);
		return client;
	}
}