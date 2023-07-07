package fr.maboite.ebru.jsf.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {
	
	private String loadId;
	
	
	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public String createNew() {
		System.out.println("client");
		return "client";
	}

	public void onLoad() {
		System.out.println("je suis en train de charger la vue");
		System.out.println("je charge le client avec id: " + loadId);
		
	}

}
