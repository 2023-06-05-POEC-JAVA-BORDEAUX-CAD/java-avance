package fr.maboite.correction.rest.controller;

import fr.maboite.correction.jpa.model.ErrorMessage;
import jakarta.ejb.Stateless;
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
@Path("/clients")
@Produces("application/json")
public class MonPremiereRestController {

	
	
	@GET
	@Path("/recuperation/{id}")
	public Response getMonPremierRestBean(@PathParam("id") int id) {
		System.out.println("declenchement avec recup id " + id);
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		if (id < 0) {
			ErrorMessage erreur = new ErrorMessage();
			erreur.setMessage("erreur !!!");
			return Response.status(Status.NOT_FOUND).entity(erreur).build();


		}
		monPremierRestDto.setId(id);
		monPremierRestDto.setName("test");
	//	return monPremierRestDto;
		return Response.ok(monPremierRestDto).header("test","testtest").build();

	}
	
	@GET
	@Produces("text/plain")
	@Path("/recuperation/textplain/{id}")
	public String  getMonPremierRestBean2(@PathParam("id") int id) {
		System.out.println("declenchement avec recup id + " + id);
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId(id);
		monPremierRestDto.setName("test");
		return "id : " + monPremierRestDto.getId() + " name: " + monPremierRestDto.getName() ;
	}
	
	@POST
	@Path("/post")
public void post(@Valid MonPremierRestDto monPremierRestDto) {
		
		System.out.println("recuperé id: " + monPremierRestDto.getId() + " name: " + monPremierRestDto.getName());
	}
	
	@DELETE
	@Path("/delete/{id}")
	public void delete(int id) {
		

	}
	
	
}
