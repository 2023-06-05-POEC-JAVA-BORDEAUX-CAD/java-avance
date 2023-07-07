package fr.maboite.gabriel.jsf.bean;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;


@Named
@RequestScoped
public class ManagedBean implements Serializable {
	
	public String createNew() {
		return "client";//spécifie la page xhtml concerné
	}
	

}
