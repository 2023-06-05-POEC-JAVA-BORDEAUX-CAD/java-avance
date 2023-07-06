package dev.loicmoreaux.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class PremierFaceBean {
	private static final String MESSAGE = "Un message qui provient d'une classe Java !";

	public String getMessage() {
		return MESSAGE;
	}
	
	public String otherMessage() {
		return "Un autre message";
	}
}
