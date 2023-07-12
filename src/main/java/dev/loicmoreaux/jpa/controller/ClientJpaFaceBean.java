package dev.loicmoreaux.jpa.controller;

import java.util.List;

import dev.loicmoreaux.jpa.model.ClientJpa;
import dev.loicmoreaux.jpa.model.OrderJpa;
import dev.loicmoreaux.jpa.service.ClientJpaService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientJpaFaceBean {
	private ClientJpa client = new ClientJpa();
	
	@Inject
	private ClientJpaService clientService;
	
	/**
	 * Constructor
	 */
	public ClientJpaFaceBean() {}
	
	/**
	 * Getters and Setters
	 */
	public ClientJpa getClient() {
		return client;
	}

	public void setClient(ClientJpa client) {
		this.client = client;
	}
	
	/**
	 * Create or Update client into database
	 */
	public void save() {
		clientService.save(client);
		System.out.println("sauvegarde de client dans la BDD");
	}
	
	/**
	 * Get all clients into database and display in html table
	 * @return String
	 */
	public String getClients() {
		String ul = "";
		List<ClientJpa> clients = clientService.getClients();
		for(ClientJpa client : clients) {
			ul += "<tr>";
			ul += "<td>" + client.getId() + "</td>";
			ul += "<td>" + client.getCompanyName() + "</td>";
			ul += "<td>" + client.getFirstName() + "</td>";
			ul += "<td>" + client.getLastName() + "</td>";
			ul += "<td>" + client.getPhone() + "</td>";
			ul += "<td>" + client.getCity() + "</td>";
			ul += "<td>" + client.getState() + "</td>";
			ul += "</tr>";
		}
		return ul;
	}
	
}
