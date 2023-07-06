package dev.loicmoreaux.jsf.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
	
	public String getLocaleTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy HH:mm", Locale.FRANCE);
		return LocalDateTime.now().format(formatter);
	}
}
