package fr.boite.philippe.jsf.controller;

import fr.boite.philippe.jsf.service.ClientService;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class ClientFaceBeanTp {
	
	@Inject
	private ClientService clientService;
	
	private ClientFormBean clientFormBean = new ClientFormBean();
	
/*	public String save() {
		clientService.save(clientFormBean.getClient());
		System.out.println("Client saved: " + clientFormBean.getClient());
		return null;
	}*/
	
	public ClientFormBean getClientFormBean() {
		return clientFormBean;
	}
	
	public void setClientFormBean(ClientFormBean clientFormBean) {
		this.clientFormBean = clientFormBean;
	}
}
