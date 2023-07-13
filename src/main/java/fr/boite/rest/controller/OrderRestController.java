package fr.boite.rest.controller;

import fr.boite.rest.dto.OrderRestDto;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderRestController {

	@GET
	@Path("/{id}")
	public OrderRestDto getOrder(@PathParam("id") Integer id) {
		System.out.println("La méthode GET de récupération de la commande a été appelée avec l'id " + id);
		// Obtenir les détails de la commande à partir de la base de données ou d'une
		// autre source de données
		OrderRestDto orderRestDto = new OrderRestDto();
		orderRestDto.setId(id);
		// Définir les autres propriétés de la commande
		return orderRestDto;
	}

	@POST
	public OrderRestDto createOrder(OrderRestDto orderRestDto) {
		System.out.println("La méthode POST de création de la commande a été appelée " + orderRestDto.getId());
		// Enregistrer la commande dans la base de données ou traiter les données reçues
		return orderRestDto;
	}

	@DELETE
	@Path("/{id}")
	public void deleteOrder(@PathParam("id") Integer id) {
		System.out.println("La méthode DELETE de suppression de la commande a été appelée avec l'id " + id);
		// Supprimer la commande de la base de données ou effectuer d'autres actions
		// nécessaires
	}
}
