package fr.boite.philippe.jsf.controller;

import fr.boite.philippe.jsf.service.ClientService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBeanTp {
	
	@Inject
	private ClientService clientService;
	
	private ClientFormBean client = new ClientFormBean();
	private Integer loadId;

	public ClientFormBean getClient() {
		return client;
	}

	public void setClient(ClientFormBean client) {
		this.client = client;
	}

	public Integer getLoadId() {
		return loadId;
	}

	public void setLoadId(Integer loadId) {
		this.loadId = loadId;
	}
	
	public void onLoad() {
		System.out.println(loadId);
		this.client =clientService.load(loadId);
	}
	
	public String save() {
		clientService.save(client);
		System.out.println("Client saved: " + loadId);
		return null;
	}
	
	
}
