package dev.loicmoreaux.tpjsf.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;

import dev.loicmoreaux.tpjsf.model.ClientJsf;
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
	private String id;
	
	@Inject
	private ClientJsfService clientService;
	
	/*
	 * Constructor
	 */
	public ClientJsfFaceBean() {}
	
	/*
	 * Getters and Setters
	 */	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public ClientJsfFormBean getClient() {
		return client;
	}
	
	public void setClient(ClientJsfFormBean client) {
		this.client = client;
	};
	
	/*
	 * Methods
	 */
	public ClientJsfFormBean toClientJsfFormBean(ClientJsf client) {
		ClientJsfFormBean clientFormBean = new ClientJsfFormBean();
		clientFormBean.setId(client.getId());
		clientFormBean.setCompany_name(client.getCompany_name());
		clientFormBean.setFirst_name(client.getFirst_name());
		clientFormBean.setLast_name(client.getLast_name());
		clientFormBean.setEmail(client.getEmail());
		clientFormBean.setPhone(client.getPhone());
		clientFormBean.setAddress(client.getAddress());
		clientFormBean.setZip_code(client.getZip_code());
		clientFormBean.setCity(client.getCity());
		clientFormBean.setCountry(client.getCountry());
		clientFormBean.setState(client.isState());
		return clientFormBean;
	}
	
	public String save() {
		clientService.addClient(client.toClient());
		System.out.println("sauvegarde du client");
		
		return null;
	}
	
	public String getAllClients() throws JsonProcessingException {
		return clientService.getClientsToString();
	}
	
	public void loadClient() {
		if(this.getId() == null || this.getId().isEmpty()) return;
		Integer id = Integer.parseInt(this.getId());
		ClientJsf loadedClient = clientService.getClientById(id);
		if(loadedClient != null) {
			this.setClient(this.toClientJsfFormBean(loadedClient));
		}
		
	}
}
