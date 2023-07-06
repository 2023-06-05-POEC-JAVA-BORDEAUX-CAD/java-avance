package fr.noellie.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {
	
	 private String message = "Ce message vient du controller ClientFaceBean";
	 
	 public String getMessage() {
		 return message;
	 }
	 
}