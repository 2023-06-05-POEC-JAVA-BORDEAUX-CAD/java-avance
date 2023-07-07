package fr.nicolas.facebean.Messenger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Messenger {
	
	private Message message = new Message();

	public Messenger() {
		this.message.setId(1);
		this.message.setMessage("LOL");
	};
	
	public Message getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message.setMessage(message);
	}
	
	public String processForm() {
		
//		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//	    String msg = ec.getRequestParameterMap().get("msgForm:message");
//	    System.out.println(msg);
	    return "first_exo";
	}
	
	public String goToClient() {
		return "client";
	}
	
}
