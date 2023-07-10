package fr.maboite.jsf;

import java.time.LocalDate;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

import jakarta.inject.Named;

// annoté pourinjected dans cdi 


 @Named
 @RequestScoped
public class ClientFaceBean {

	private String nom = "Farid";
	private String ville = "Tombouctou";
	private int age = 70;	
	private String message = "message statique pour test";	
	private Boolean en_vacance = true;		
	private Integer annee = 1500;	
	private LocalDate date  = LocalDate.now();
	private String loadId;
	
	
	public String createNew() {	
		System.out.println("Message pour test reussite exercice");   
		return "client";
	} 
	
	public void onLoad() {
		System.out.println("Message 1");   
		System.out.println("Message 2" + loadId);   

	}
	
	public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        nom = "john";
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        ville = "Tombouctou";
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        age = 30;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getEn_vacance() {
		return en_vacance;
	}

	public void setEn_vacance(Boolean en_vacance) {
		this.en_vacance = en_vacance;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}
}