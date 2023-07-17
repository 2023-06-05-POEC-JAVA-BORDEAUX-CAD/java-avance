package fr.maboite.correction.rest.controller;

import fr.maboite.correction.jpa.model.Client;
import fr.maboite.correction.jpa.model.ErrorMessage;
import fr.maboite.correction.jpa.model.Order;
import fr.maboite.correction.service.ClientService;
import fr.maboite.correction.service.OrderService;
import fr.maboite.dto.OrderDto;
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
@Path("/orders")
@Produces("application/json")
public class OrderRestController {

	@Inject
	private ClientService clientService;
	@Inject
	private OrderService orderService;

	@GET
	@Path("/recuperation/{id}")
	public Response getOrder(@PathParam("id") int id) {
		System.out.println("declenchement avec recup id " + id);
		if (id < 0) {
			ErrorMessage erreur = new ErrorMessage();
			erreur.setMessage("erreur !!!");
			return Response.status(Status.NOT_FOUND).entity(erreur).build();

		}
		Order order = orderService.load(id);
		OrderDto orderDto = new OrderDto();
		orderDto.setId(order.getId());
		orderDto.setClientId(order.getClientId().getId());
		orderDto.setDesignation(order.getDesignation());
		orderDto.setNbDays(order.getNbDays());
		orderDto.setState(order.getState());
		orderDto.setTypePresta(order.getTypePresta());
		orderDto.setUnitPrice(order.getUnitPrice());

		// return orderDto;
		return Response.ok(orderDto).header("reponse", "ca marche").build();

	}

	@SuppressWarnings("unused")
	@POST
	
	@Path("/post")
	public void post( @Valid OrderDto orderDto) {
	    System.out.println("TRIGGER POST");

	    // Charger le client
	    Client clientLoaded = clientService.load(orderDto.getClientId());
	    System.out.println(clientLoaded.toString());

	    // Vérifier si le client existe
	    if (clientLoaded == null) {
	        System.out.println("CLIENT NON TROUVÉ : ÉCHEC DE LA SAUVEGARDE");
	        return;
	    }

	   
	    Order orderToSave = orderDto.toEntity();
	    orderToSave.setClientId(clientLoaded);
	    orderService.save(orderToSave);
	    System.out.println("Ajouté : " + orderToSave.toString());
	}

	@DELETE
	@Path("/delete/{id}")
	public void delete(@PathParam("id")  int id) {
		System.out.println("trigger delete");
		 orderService.deleteById(id);

	}

	public Client validClientOrder(Client clientToSave) {
		System.out.println("TRIGGER VALIDATION POST ");
		Client clientValide = new Client();

		clientValide.setEmail(clientToSave.getEmail());
		clientValide.setCompanyName(clientToSave.getCompanyName());
		clientValide.setAddress(clientToSave.getAddress());
		clientValide.setCity(clientToSave.getCity());
		clientValide.setCountry(clientToSave.getCountry());
		clientValide.setFirstName(clientToSave.getFirstName());
		clientValide.setId(clientToSave.getId());
		clientValide.setLastName(clientToSave.getLastName());
		clientValide.setPhone(clientToSave.getPhone());
		clientValide.setZipCode(clientToSave.getZipCode());
		clientValide.setState(clientToSave.getState());
		return clientValide;
	}

}
