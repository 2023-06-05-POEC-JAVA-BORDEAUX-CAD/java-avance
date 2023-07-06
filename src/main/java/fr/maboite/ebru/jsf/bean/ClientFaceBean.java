package fr.maboite.ebru.jsf.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {
	
	public String createNew() {
		System.out.println("client");
		return "client";
	}
	
	

}
