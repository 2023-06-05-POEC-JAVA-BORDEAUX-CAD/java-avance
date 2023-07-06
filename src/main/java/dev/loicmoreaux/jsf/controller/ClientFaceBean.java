package dev.loicmoreaux.jsf.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ClientFaceBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Un message qui provient d'une classe Java !";
	private String name = "Client";
	private boolean myBoolean = true;
	private Integer myInteger = 39;
	private Integer counter = 0;
	
	public ClientFaceBean() {}

	public String getMessage() {
		return MESSAGE;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public String otherMessage() {
		return "Un autre message";
	}
	
	public String getDateTimeLocale() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy HH:mm:ss", Locale.FRANCE);
		return LocalDateTime.now().format(formatter);
	}
	
	public String createNew() {
		this.counter++;
		return "client-view";
	}
	
	public String goIndex() {
		this.counter++;
		return "page1";
	}
}
