package dev.loicmoreaux.jpa.controller;

public class MessageRestJpa {
	
	private final String message;
	
	/**
	 * @param message
	 */
	public MessageRestJpa(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
