package fr.maboite.correction.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * ManagedBean JSF faisant office de contrôleur.
 */
@Named
@RequestScoped
public class ClientFaceBean {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String createNew() {
		System.out.println("Création d'un client");
		return "client";
	}

	public void onLoad() {
		System.out.println("Je suis en train de charger la vue client");
		System.out.println("Je charge le client avec l'id : " + id);
	}

}