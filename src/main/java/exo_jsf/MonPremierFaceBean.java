package exo_jsf;

import java.time.LocalDateTime;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MonPremierFaceBean {

	private String message = "Ce message vient du contrôleur";

	public String getMessage() {
		return LocalDateTime.now().toString();
	}
	
	public String getCoucou() {
		return "Salut ! ";
	}

	public void setMessage(String message) {
		this.message = message;
	}

}