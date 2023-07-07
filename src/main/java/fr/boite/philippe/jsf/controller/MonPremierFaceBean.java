package fr.boite.philippe.jsf.controller;

import java.time.LocalDateTime;

//import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
//import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
//@SessionScoped
//@ApplicationScoped

public class MonPremierFaceBean {

	private String message = "ce message de philippe";

	public String getMessage() {
		return LocalDateTime.now().toString();
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
