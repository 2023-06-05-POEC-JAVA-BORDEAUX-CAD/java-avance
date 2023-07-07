package dev.loicmoreaux.coursjsf.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class PremierFaceBean {
	private static final String MESSAGE = "Un message qui provient d'une classe Java !";
	private boolean myBoolean = true;
	private Integer myInteger = 13;
	
	public PremierFaceBean() {}

	public String getMessage() {
		return MESSAGE;
	}
	
	public boolean isMyBoolean() {
		return myBoolean;
	}

	public void setMyBoolean(boolean myBoolean) {
		this.myBoolean = myBoolean;
	}

	public Integer getMyInteger() {
		return myInteger;
	}

	public void setMyInteger(Integer myInteger) {
		this.myInteger = myInteger;
	}

	public String otherMessage() {
		return "Un autre message";
	}
	
	public String getDateTimeLocale() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy HH:mm:ss", Locale.FRANCE);
		return LocalDateTime.now().format(formatter);
	}
}
