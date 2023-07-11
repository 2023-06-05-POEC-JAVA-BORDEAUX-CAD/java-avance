package fr.nicolas.jpa.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.nicolas.jpa.Service.ClientService2;
import fr.nicolas.jpa.Entity.Client;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientController2 {

	@Inject
	ClientService2 clientService;
	
	private String id;
	
	private Client client;
	
	private Map<String, String> clientsIds = new HashMap<>();
	
	private List<Client> clients;

	
	public void onLoad() {
		
		if(id !=null) {
			try {
				Integer id = Integer.valueOf(this.id);
				this.client = this.clientService.getClientById(id);
				
			}
			catch(NumberFormatException e) {
				
			}
			catch(NullPointerException e) {
				System.out.println("Client invalide avec cet id : " + this.id +"");
			}
		} else {
			try {
				
				Client nclient = new Client();
				nclient.setCompanyName("EDF");
				nclient.setFirstName("Julien");
				nclient.setLastName("Leperse");
				nclient.setEmail("julien.leperse@edf.com");
				
				this.clientService.save(nclient);
				
				this.clients = this.clientService.getAllClients();
				for(Client client: this.clients) {
					String sId = String.valueOf(client.getId());
					this.clientsIds.put("Command N° : " + sId,"1");
				}
				
				Integer clientTODeleteID = this.clients.get(1).getId();
				this.clientService.deleteById(clientTODeleteID);
				
				
			} catch(NullPointerException e) {
				System.out.println("Null object in controller layer at clients " + e.getMessage());
			}
		}
		
	}
	
	
	
	
	public String getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public Map<String, String> getClientsIds() {
		return clientsIds;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setClientsIds(Map<String, String> clientsIds) {
		this.clientsIds = clientsIds;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
}
