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
	private String loadId;
	
	private MessageFormBean messageForm = new MessageFormBean();
	
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

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public MessageFormBean getMessageForm() {
		return messageForm;
	}

	public void setMessageForm(MessageFormBean messageForm) {
		this.messageForm = messageForm;
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
		return "client";
	}
	
	public String goIndex() {
		this.counter++;
		return "page1";
	}
	
	public void onLoad() {
		System.out.println("l'id passé est : " + this.displayLoadId());
	}
	
	public String displayLoadId() {
		if(this.getLoadId() == null || this.getLoadId().isEmpty()) return "paramètre absent";
		return this.getLoadId();
	}
	
	public void save() {
		System.out.println("Save Ok");
	}
}
