/*package dev.loicmoreaux.jpa.converter;

import dev.loicmoreaux.jpa.model.ClientJpa;
import dev.loicmoreaux.jpa.service.ClientJpaService;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(forClass = ClientJpa.class, managed = true)
public class ClientJpaConverter implements Converter<ClientJpa>{
	
	@Inject
	private ClientJpaService clientService;

	@Override
	public ClientJpa getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.isEmpty()) {
			return null;
		}
		return clientService.getClientById(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, ClientJpa value) {
		if(value == null) {
			return "";
		}
		return String.valueOf(value.getId());
	}
}*/
