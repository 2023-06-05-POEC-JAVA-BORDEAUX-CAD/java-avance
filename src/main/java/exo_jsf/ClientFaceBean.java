package exo_jsf;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean implements Serializable {


	private static final long serialVersionUID = 1L;
	private String loadId;
	
	private ClientFormBean client = new ClientFormBean();
	
	@Inject
	private ClientServiceJsf clientService;
	
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
		// compteur++;
		// System.out.println("Big Joe a appuyer sur le bouton" + compteur + "fois");
		System.out.println("création du client");
		return "client";
	}

	public void onLoad() {
		System.out.println("I'm loading the view");
		System.out.println("Message loaded with id : " + loadId);
		this.client.setId(loadId);
		this.client.setCompanyName("le nom de la company" + loadId);
	}
	
	public String save() {
		System.out.print("Sauvegarde appelée");
		this.clientService.save(client);
		return null;
	}

}