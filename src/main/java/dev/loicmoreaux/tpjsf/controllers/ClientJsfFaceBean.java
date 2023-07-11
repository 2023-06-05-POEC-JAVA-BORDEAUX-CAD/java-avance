package dev.loicmoreaux.tpjsf.controllers;

import dev.loicmoreaux.tpjsf.service.ClientJsfService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientJsfFaceBean {
	/*
	 * Attributes
	 */
	private ClientJsfFormBean client = new ClientJsfFormBean();
	
	@Inject
	private ClientJsfService clientService;
	
	/*
	 * Constructor
	 */
	public ClientJsfFaceBean() {}
	
	/*
	 * Getters and Setters
	 */
	public ClientJsfFormBean getClient() {
		return client;
	}
	
	public void setClient(ClientJsfFormBean client) {
		this.client = client;
	};
	
	/*
	 * Methods
	 */
	public String save() {
		clientService.addClient(client.toClient());
		System.out.println("sauvegarde du client");
		
		return null;
	}
}
