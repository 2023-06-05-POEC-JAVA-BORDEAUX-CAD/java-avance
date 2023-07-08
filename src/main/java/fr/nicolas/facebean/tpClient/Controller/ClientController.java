package fr.nicolas.facebean.tpClient.Controller;

import java.util.List;
import java.util.ArrayList;
import fr.nicolas.facebean.tpClient.DTO.ClientDTO;
import fr.nicolas.facebean.tpClient.Entity.Client;
import fr.nicolas.facebean.tpClient.Service.ClientService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientController {

	@Inject
	private ClientService clientService;
	
	@Inject
	private ClientDTO clientDTO;
	
	private String id;
	private String errMessage;
	private String saveMessage;
	private List<Client> clients;
	
	public Client getClientById(Integer id) {
		return this.clientService.getClient(id);
	}
	
	public List<Client> getClientsList() {
		return this.clientService.getClients();
	}
	
	public void onLoad() {
		
		if(id !=null) {
			try {
				Integer id = Integer.valueOf(this.id);
				Client cli = this.getClientById(id);
				this.clientDTO.setId(cli.getId());
				this.clientDTO.setFirstName(cli.getFirstName());
				this.clientDTO.setLastName(cli.getLastName());
				this.clientDTO.setCompanyName(cli.getCompanyName());
			}
			catch(NumberFormatException e) {
				
			}
			catch(NullPointerException e) {
				this.errMessage = "Client invalide avec cet id : " + this.id +"";
			}
		} else {
			try {
				this.clients = this.getClientsList();
				if(this.clients == null) throw new NullPointerException();
			}
			catch(NullPointerException e) {
				System.out.println("Null object in controller layer : " + e.getMessage());
				this.errMessage = "Liste de clients introuvable";
			}
		}
		
	}
	
	public String save() {
		
		Client cli = new Client();
		cli.setFirstName(this.clientDTO.getFirstName());
		cli.setLastName(this.clientDTO.getLastName());
		cli.setCompanyName(this.clientDTO.getCompanyName());
		this.clientService.save(cli);
		this.saveMessage = "Client sauvegardé";
		return "client";
	}
	
	public ClientDTO getClientDTO() {
		return this.clientDTO;
	}
		
	public ClientService getClientService() {
		return this.clientService;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public String getSaveMessage() {
		return saveMessage;
	}

	public void setSaveMessage(String saveMessage) {
		this.saveMessage = saveMessage;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clientsDTO) {
		this.clients = clientsDTO;
	}
	
	
}
