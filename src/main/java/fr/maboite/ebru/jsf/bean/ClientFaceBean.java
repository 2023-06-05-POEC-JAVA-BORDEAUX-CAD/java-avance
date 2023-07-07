package fr.maboite.ebru.jsf.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {

	private String loadId;

	private ClientFormBean client = new ClientFormBean();
	
	@Inject
	private ClientsServiceJsf clientService;
	

	public ClientFormBean getClient() {
		return client;
	}

	public void setClient(ClientFormBean client) {
		this.client = client;
	}

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public String createNew() {
		System.out.println("client");
		return "clients";
	}

	public void onLoad() {
		System.out.println("je suis en train de charger la vue");
		System.out.println("je charge le client avec id: " + loadId);
		int idint = Integer.parseInt(loadId);
		this.client.setId(idint);
		this.client.setCompanyName("le nom de la company: " + loadId);
		this.clientService.load(idint);
	}

	public String save() {
		System.out.println("je sauvegarde client");
		this.clientService.save(client);
		return null;

	}

}
