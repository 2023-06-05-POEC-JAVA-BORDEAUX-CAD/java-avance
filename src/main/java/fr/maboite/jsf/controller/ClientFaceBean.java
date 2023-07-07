package fr.maboite.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {

	@Inject
	ClientService clientService;

	private ClientFormBean client = new ClientFormBean();
	private Integer loadId;

	public void onLoad() {
		System.out.println(loadId);
		this.client = clientService.load(loadId);		
	}

	public String save() {
		System.out.println("Je sauvegarde le client" + loadId);
		this.clientService.save(client);
		return null;
	}

	public ClientFormBean getClient() {
		return client;
	}

	public Integer getLoadId() {
		return loadId;
	}

	public void setClient(ClientFormBean client) {
		this.client = client;
	}

	public void setLoadId(Integer loadId) {
		this.loadId = loadId;
	}

}
