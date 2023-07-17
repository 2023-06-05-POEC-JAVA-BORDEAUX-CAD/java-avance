package fr.maboite.ebru.rest.controller;

import fr.maboite.ebru.jpa.entity.ClientJPA;
import fr.maboite.ebru.jpa.entity.ClientJpaService;
import fr.maboite.ebru.jpa.entity.OrderJPA;
import fr.maboite.ebru.jpa.entity.OrderJpaService;
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
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/orders") // Le nom de la r essource est très generalement au pluriel
@Produces("application/json") // format incontournable
public class OrderController {

	@Inject
	private ClientJpaService clientJpaService;

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
	
	@Inject
	private OrdersDto orderDto;

	@GET // (recupere l'id
	@Path("/{id}")
	public Response getRestControllerBean(@PathParam("id") Integer id) {

		System.out.println(" la methode de recuparation a été appeleée avec l'id " + id);

		if (id < 0) {
			return Response.status(Status.NOT_FOUND).build();

		}
		
		orderDto.setTypePresta(" ");
		orderDto.setId(id);
		orderDto.setClientId(5);

		return Response.ok(orderDto).header("yani", "iyi").build();
	}

	@POST
	@Path("/")
	public Response post(@Valid OrdersDto orderDto) {

		System.out.println("j'ai un DTO où id est : " + orderDto.getId() + " et le nom : " + orderDto.getTypePresta()
				+ "le clientId : " + orderDto.getClientId()
				+ "la designation : " +orderDto.getDesignation());

		if (orderDto == null) {
			return Response.status(Status.NOT_FOUND).build();

		}

		// 1 utilisation de toJpA

		OrderJPA orderController = orderDto.toOrderJPA(orderDto);

		if (orderDto.getClientId() != null) {
			ClientJPA client = clientJpaService.load(orderDto.getClientId());

			if (client == null) {
				return Response.status(Status.BAD_REQUEST).build();
			}

			orderController.setClient(client);

		}
		OrderJPA saveOrder = orderJpaService.save(orderController);

		// 2 retransforme cette entité en DTO

		OrdersDto orderController2 = saveOrder.toOrdersDto(saveOrder);
		
			

		// 3 renvoi du DTO dans la réponse

		{
			return Response.ok(orderController2).build();
		}

	}

	@DELETE
	@Path("/{id}/{clientId}")
	public void delete(@PathParam("id") Integer id, @PathParam("clientId") Integer clientId) {

		System.out.println("j'ai supprimé l'id : " + id + "et" + clientId);

	}

}
