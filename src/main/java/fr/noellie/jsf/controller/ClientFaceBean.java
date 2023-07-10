package fr.noellie.jsf.controller;

import fr.noellie.jsf.service.ClientServiceTPJSF;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {

	private String messageClient = "Ce message vient du controller ClientFaceBean";

	private Integer loadId;

	private ClientFormBean client = new ClientFormBean();

	@Inject
	private ClientServiceTPJSF clientService;

	public String getMessage() {
		return messageClient;
	}

	public Integer getLoadId() {
		return loadId;
	}

	public ClientFormBean getClient() {
		return client;
	}

	public void setMessageClient(String messageClient) {
		this.messageClient = messageClient;
	}

	public void setLoadId(Integer loadId) {
		this.loadId = loadId;
	}

	public void setClient(ClientFormBean client) {
		this.client = client;
	}

	public void onLoad() {
		System.out.println("Je suis en train de charger la vue client");
		this.client = this.clientService.load(this.loadId);
		System.out.println("La vue client n° " + loadId + " est chargée !");
	}

	public String save() {
		System.out.println("Je sauvegarde le client n° " + client.getId());
		this.clientService.save(client);
		return "client";
	}
}