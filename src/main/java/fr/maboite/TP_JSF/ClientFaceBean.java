package fr.maboite.TP_JSF;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean{
	
	private String companyName ;
	private Integer id;
	
	// Getters & Setters

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
	

	public void onLoad() {
		System.out.println("Je charge le message avec l'id : " + id);
		}
	
	public void save()
	{
		System.out.println("Sauvegarde appelée.");
		System.out.println("Id : " + id);
		System.out.println("Compagny name : " + companyName);
	}

}
