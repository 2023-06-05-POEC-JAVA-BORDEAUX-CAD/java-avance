package fr.noellie.jsf.controller;

import fr.noellie.jpa.dao.ClientJPADao;
import fr.noellie.jpa.model.ClientJPA;
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
	
	@Inject
	private ClientJPADao clientJPADao;

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
	
	public void sauvegardeClientJPA() {
		ClientJPA clientJPA = new ClientJPA();
		clientJPA.setCompanyName("Sopra Steria");
		clientJPA.setFirstName("Michel");
		clientJPA.setLastName("Drücker");
		clientJPA.setEmail("michel.drucker@mail.fr");
		clientJPA.setPhone("06 06 06 06 06");
		clientJPA.setAdress("123 Rue des Lilas");
		clientJPA.setZipCode("75002");
		clientJPA.setCity("Paris");
		clientJPA.setCountry("France");
		clientJPA.setState(0);
		ClientJPA savedClient = clientJPADao.save(clientJPA);
		
		ClientJPA loadedClient = clientJPADao.load(savedClient.getId());
		System.out.println("En base, j'ai un client dont l'entreprise est " 
				+ loadedClient.getCompanyName()
				+ " et dont le nom complet est "
				+ loadedClient.getFirstName() + " " + loadedClient.getLastName());
	}
}