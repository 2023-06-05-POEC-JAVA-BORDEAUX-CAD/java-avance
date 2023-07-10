package fr.noellie.jsf.controller;

import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Named;

@Named
@RequestScoped
public class MessageFaceBean {

	private int compteur;

	private String loadId;

	private MessageFormBean message = new MessageFormBean();

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
		System.out.println("Quelqu'un a appuyé sur ce lien " + compteur + " fois");
		return "message";
	}

	public void onLoad() {
		System.out.println("Je suis en train de charger la vue");
		this.message.setId(loadId);
		this.message.setValue("La valeur de : " + loadId);
	}

	public String save() {
		System.out.println("Je sauvegarde le message");
		return "message";
	}

}
