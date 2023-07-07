package fr.boite.philippe.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MessageFaceBean {
	private int compteur;
	private String loadId;

	private MessageFormBean message = new MessageFormBean();

	public String createNew() {
		compteur++;
		System.out.println("N° de click " + compteur + " fois");
		return "message";
	}

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public void onLoad() {
		System.out.println("changer la vue");
		System.out.println("changer le message avec l'id : " + loadId);
		this.message.setId(loadId);
		this.message.setValue("la valeur de : " + loadId);
	}

	public String save() {
		System.out.println("je sauvegarde le message");
		return "philippe-vue-jsf";
	}

	public MessageFormBean getMessage() {
		return message;
	}

	public void setMessage(MessageFormBean message) {
		this.message = message;
	}
}
