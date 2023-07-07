package fr.maboite.facebean2;


import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;


@Named
@RequestScoped
public class ClientFaceBean  {

	private String companyName;
	private Integer id;
	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public void save() {
		System.out.println("enregistrment client avec l'id : " + id + " companyName : " + companyName);

		System.out.println("sauvegarde message");
		
	}




}