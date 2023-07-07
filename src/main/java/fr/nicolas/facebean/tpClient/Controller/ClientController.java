package fr.nicolas.facebean.tpClient.Controller;

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
	
	public Client getClientById(Integer id) {
		return this.clientService.getClient(id);
	}
	
	public void onLoad() {
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
		catch(NullPointerException |IllegalStateException e) {
			this.errMessage = "Client invalide avec cet id : " + this.id +"";
		}
	}
	
	public ClientDTO getClientDTO() {
		return this.clientDTO;
	}
		
	public ClientService getClientService() {
		return this.clientService;
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
	
	
}
