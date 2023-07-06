package fr.nicolas.facebean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Messenger {
	
	private String message;

	public Messenger() {
	};
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void processForm() {
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    String msg = ec.getRequestParameterMap().get("msgForm:message");
	    System.out.println(msg);
	    this.setMessage(msg);
	}
	
	public String goToClient() {
		return "client";
	}
	
}
