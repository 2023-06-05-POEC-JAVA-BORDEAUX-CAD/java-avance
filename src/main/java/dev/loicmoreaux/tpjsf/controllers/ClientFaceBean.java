package dev.loicmoreaux.tpjsf.controllers;


import dev.loicmoreaux.tpjsf.service.ClientService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {
	/*
	 * Attributes
	 */
	private ClientFormBean client = new ClientFormBean();
	
	@Inject
	private ClientService clientService;
	
	/*
	 * Constructor
	 */
	public ClientFaceBean() {}
	
	/*
	 * Getters and Setters
	 */
	public ClientFormBean getClient() {
		return client;
	}
	
	public void setClient(ClientFormBean client) {
		this.client = client;
	};
	
	/*
	 * Methods
	 */
	public String save() {
		
		System.out.println("sauvegarde du client");
		return null;
	}
}
