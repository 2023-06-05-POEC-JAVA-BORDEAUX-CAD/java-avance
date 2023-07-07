package fr.maboite.correction.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MessageFaceBean {

	private int compteur;

	private String loadId;

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
		System.out.println("Je suis en train de charger la vue");
		System.out.println("Je charge le message avec l'id: " + loadId);
	}

}