package fr.maboite.correction.jsf.service;

import java.time.LocalDate;

import fr.maboite.correction.jsf.controller.MessageFormBean;
import jakarta.ejb.Stateless;

@Stateless
public class MessageService {

	public void save(MessageFormBean message) {
		System.out.println("Je sauvegarde le message");
		System.out.println("id: " + message.getId());
		System.out.println("value: " + message.getValue());
	}

	public MessageFormBean load(String loadId) {
		System.out.println("Je charge le message avec l'id: " + loadId);
		MessageFormBean message = new MessageFormBean();
		message.setId(loadId);
		message.setValue("La valeur de : " + loadId);
		return message;
	}

}
