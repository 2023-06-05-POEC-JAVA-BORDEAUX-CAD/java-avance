package dev.loicmoreaux.tpjsf.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {
	/*
	 * Attributes
	 */
	private ClientFormBean client = new ClientFormBean();
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
