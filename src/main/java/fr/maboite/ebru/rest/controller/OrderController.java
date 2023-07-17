package fr.maboite.ebru.rest.controller;

import fr.maboite.ebru.jpa.entity.EtatCommande;
import fr.maboite.ebru.jpa.entity.OrderJPA;
import fr.maboite.ebru.jpa.entity.OrderJpaService;
import jakarta.ws.rs.core.Response.Status;
import fr.maboite.ebru.rest.dto.OrdersDto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("/orders") // Le nom de la r essource est très generalement au pluriel
@Produces("application/json") // format incontournable
public class OrderController {

	@Inject
	private OrderJpaService orderJpaService;

//	@GET // (recupere l'id
//	@Path("/{id}")
//	public OrdersDto getRestControllerBean(@PathParam("id") Integer id) { 
//
//		System.out.println(" la methode de recuparation a été appeleée avec l'id " + id);
//		OrdersDto ordersDto = new OrdersDto();
//		ordersDto.setTypePresta("Coaching");
//		ordersDto.setId(id);
//		ordersDto.setClientId(5);
//
//		return ordersDto;
//
//	}

	public OrderJPA toOrderJPA(OrdersDto dto) {
		OrderJPA order3 = new OrderJPA();
		order3.setType(dto.getTypePresta());
		order3.setDesignation(dto.getDesignation());
//		order3.setClient();
		order3.setEtat(EtatCommande.CANCELLED);
		return orderJpaService.save(order3);
	}

	@GET // (recupere l'id
	@Path("/{id}")
	public Response getRestControllerBean(@PathParam("id") Integer id) {

		System.out.println(" la methode de recuparation a été appeleée avec l'id " + id);

		if (id < 0) {
			return Response.status(Status.NOT_FOUND).build();

		}

		OrdersDto ordersDto = new OrdersDto();
		ordersDto.setTypePresta(" ");
		ordersDto.setId(id);
		ordersDto.setClientId(5);

		return Response.ok(ordersDto).header("yani", "iyi").build();
	}

	@POST
	@Path("/")
	public OrdersDto post(@Valid OrdersDto orderDto) {

		System.out.println("j'ai un DTO où id est : " + orderDto.getId() + " et le nom : " + orderDto.getTypePresta()
				+ "le clientId : " + orderDto.getClientId());
		
		//1 utilisation de toJpA
		
		//2 retransforme cette entité en DTO 
		
		//3 renvoi du DTO dans la réponse
		
		
		return orderDto;
	}

	@DELETE
	@Path("/{id}/{clientId}")
	public void delete(@PathParam("id") Integer id, @PathParam("clientId") Integer clientId) {

		System.out.println("j'ai supprimé l'id : " + id + "et" + clientId);

	}

}
