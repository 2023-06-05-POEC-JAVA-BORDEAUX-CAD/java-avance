package exo_jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {

	// private int compteur;
	private String loadId;

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public String createNew() {
		//compteur++;
		//System.out.println("Big Joe a appuyer sur le bouton" + compteur + "fois");
		System.out.println("création du client");
		return "client";
	}

	public void onLoad() {
		System.out.println("I'm loading the view");
		System.out.println("Message loaded with id : " + loadId);
	}

}