package Clientjsf;

import java.io.Serializable;
import java.util.HashMap;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean implements Serializable {
	

	private int loadId;
	
	
	private ClientFormBean clientFormBean;
	
	@Inject
    private ClientService clientService;

	
	
	
	
	public ClientFaceBean() {
		clientFormBean = new ClientFormBean();
	}

	public ClientFormBean getClientFormBean() {
		return clientFormBean;
	}

	public void setClientFormBean(ClientFormBean clientFormBean) {
		this.clientFormBean = clientFormBean;
	}

	// methode qui affiche une ligne dans la console et renvoie un Strinfg null
	public String save() {
		//clientFormBean.setCompanyName("m2i");
	    
		System.out.println("ID: " + clientFormBean.getIdClient());
		System.out.println("Company Name: " + clientFormBean.getCompanyName());
		
		return null;
	}
	
	public void onLoad() {
		System.out.println("je suis en charge");
		
	}
}
