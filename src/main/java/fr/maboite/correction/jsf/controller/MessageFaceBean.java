package fr.maboite.correction.jsf.controller;

import fr.maboite.correction.jsf.service.MessageService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MessageFaceBean {

	private int compteur;

	private String loadId;

	private MessageFormBean message = new MessageFormBean();
	
	@Inject
	private MessageService messageService;

	public MessageFormBean getMessage() {
		return message;
	}

	public void setMessage(MessageFormBean message) {
		this.message = message;
	}

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public String createNew() {
		compteur++;
		System.out.println("Quelqu'un a appuyé sur ce bouton " + compteur + " fois");
		return "message";
	}

	public void onLoad() {
		System.out.println("Je vais demander au service de charger le message avec l'id " + loadId);
		this.message = this.messageService.load(this.loadId);
	}
	
	public String save() { 
		System.out.println("Je sauvegarde message");
		this.messageService.save(message);
		return "message";
	}

}