package fr.maboite.correction.jsf.controller;

/**
 * POJO servant à contenir
 * les données d'un message. Utile
 * pour la vue.
 */
public class MessageFormBean {

	private String id;
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
