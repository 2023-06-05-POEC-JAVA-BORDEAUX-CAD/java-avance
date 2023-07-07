package fr.maboite.gabriel.jsf.bean;

import java.time.LocalDate;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

//annoté pour injection 
@Named
@RequestScoped
public class ClientFaceBean {

	private int loadId;

	private String message = "piou piou";

	private Boolean jolie = true;

	private Integer prix = 23;

	private LocalDate date = LocalDate.now();

	public void onLoad() {
		System.out.println("je suis en charge");
	}

	public String createNew() {
		return "prem-page";// spécifie la page xhtml concerné
	}

	public String getMessage() {
		return message;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getJolie() {
		return jolie;
	}

	public void setJolie(Boolean jolie) {
		this.jolie = jolie;
	}

	public int getLoadId() {
		return loadId;
	}

	public void setLoadId(int loadId) {
		this.loadId = loadId;
	}

}
