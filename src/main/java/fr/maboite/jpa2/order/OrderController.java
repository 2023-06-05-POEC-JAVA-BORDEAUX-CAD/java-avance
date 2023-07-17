package fr.maboite.jpa2.order;

import fr.maboite.jpa2.message.ErrorMessage;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/order")
@Produces("application/json")
public class OrderController {

	@Inject
	OrderService orderService;

	// On cherche un Order par son ID
	@GET
	@Path("/{id}")
	public Response getMyOrder(@PathParam("id") Long id) {
		// on récupère l'id
		System.out.println("On recherche la commande dont l'id est : " + id);
		// On fait appel à la classe service pour récupérer l'Order en mémoire
		Order foundOrder = orderService.load(id);
		if (foundOrder != null) {
			// On le converti en Dto
			OrderDto myOrderDto = foundOrder.fromOrderToDtoOrder();
			// On l'affiche en console
			System.out.println("La commande a bien été trouvée : ");
			System.out.println(myOrderDto.getDesignation());
			// On retourne le DTO ainsi qu'un message en header
			return Response.ok(myOrderDto).header("Commande", "trouvée").build();
		} else {
			ErrorMessage errorMessage = new ErrorMessage(Status.NOT_FOUND.getStatusCode(),
					Status.NOT_FOUND.getReasonPhrase());
			return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		}

	}

	@POST
	@Path("/")
	public Response post(OrderDto orderDto) {
		// On récupère l'objet et on affiche son ID et sa désignation
		System.out.println("j'ai récupéré un DTO avec la désignation : " + orderDto.getDesignation()
				+ " correspondant à une " + orderDto.getTypePresta());

		// 1. on le transforme en Order
		// 2. on le transfère à la classe Services pour qu'elle l'ajoute en mémoire
		Order savedOrder = orderService.save(orderDto.fromOrderDtoToOrder());
		System.out.println("On vient d'ajouter un nouvel élément dont l'id est : " + savedOrder.getDesignation());

		// On récupère l l'Order Dto pour le renvoyer avec un header confirmant
		// l'enreigstrement
		OrderDto mySavedDto = savedOrder.fromOrderToDtoOrder();
		return Response.ok(mySavedDto).header("Nouvelle commande", "en mémoire").build();
	}

	@DELETE
	@Path("/delete/{id}")
	public Response deleteOrder(@PathParam("id") Long id) {
		// On récupère l'ID
		System.out.println("On va effacer l'élément dont l'id est le" + id);

		// on vérifie qu'il existe bien une entrée correspondant à l'id dans notre base
		// de donnée
		Order foundOrder = orderService.load(id);

		// s'il existe, on le supprime
		if (foundOrder.getId() != null) {
			orderService.delete(id);
			return Response.ok().header("Commande " + id + "", "effacée").build();

		} else {
			System.out.println("Il n'existe pas d'élément dont l'id est " + id);
			return Response.ok().header("Commande " + id + "", "inexistante").build();

		}

	}

//	@PUT
//	@Path("/update/")
//	public Response put(OrderDto newOrderDto) {
//		// CREATION D'UN DTO avec un ID 5
//		System.out.println("j'ai récupéré un DTO avec l'id : " + newOrderDto.getId()
//				+ ", je vais regarder si l'élément existe et le modifier si besoin");
//
//		// vérifier si l'id existe bien dans la base de données
//		if (DtoToUpdate.getId().equals(updatedDto.getId())) {
//			DtoToUpdate.setName(updatedDto.getName());
//
//			//
//			System.out.println("la commande " + newOrderDto.getId() + " a été mis à jour");
//			return Response.ok(newOrderDto).header("Commande", "mise à jour").build();
//		} else {
//			System.out.println("Le commande " + newOrderDto.getId() + " n'existe pas et a donc été ajoutée");
//
//			post(newOrderDto);
//
//		}
//
//		;
//	}

}
