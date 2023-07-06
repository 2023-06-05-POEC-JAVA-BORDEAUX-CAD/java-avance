package fr.noellie.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MonPremierFaceBean {
	
	 private String message = "Ce message vient du controller";
	 
	 public String getMessage() {
		 return message;
	 }
	 
}
