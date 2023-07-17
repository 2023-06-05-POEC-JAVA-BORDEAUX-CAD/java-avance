package Florian.TP_JAXRS;

import jakarta.ejb.Stateless;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/clients") // Le nom de la ressource est très généralement au pluriel
@Produces("application/json") // Format incontournable en REST
public class MonPremierRestController {

	@GET
	@Path("/{id}") // L'URL finale sera : classe+méthode
	public Response getMonPremierRestBean(@PathParam("id") int id) {
		System.out.println("La methode de recuperation a ete appelee avec pour id : " + id);
		
		if (id < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId(3);
		monPremierRestDto.setName("Salut!");
		return Response.ok(monPremierRestDto).header("test header1", "test header2").build();
	}

	@PUT
	@Path("/")
	public MonPremierRestDto put(MonPremierRestDto monPremierRestDto) {
		System.out.println("La methode put nous renvoie l'ID: " + monPremierRestDto.getId());
		System.out.println("La methode put nous renvoie le Name: " + monPremierRestDto.getName());
		return monPremierRestDto;
	}

	@POST
	@Path("/")
	public MonPremierRestDto post(@Valid MonPremierRestDto monPremierRestDto) {
		System.out.println("La methode post nous renvoie l'ID: " + monPremierRestDto.getId());
		System.out.println("La methode post nous renvoie le Name: " + monPremierRestDto.getName());

		return monPremierRestDto;
	}
	
	/*@DELETE
	@Path("/{id}")
	public void MonPremierRestDto delete(@PathParam("id") int id) {
		System.out.println("Suppression du client avec l'ID : " + id);	
	}*/
	
	@DELETE
	  @Path("/{id}")
	  public void MonPremierRestDtoDelete(@PathParam("id") int id){
	    OrderRestDto orderRestDto = new OrderRestDto();
	    System.out.println("La commande avec l'id " +  orderRestDto.getId() + " a ete supprimee.");
	  }
}
