package fr.boite.rest.controller;

import fr.boite.rest.dto.MonPremierRestDto;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/clients") // Le nom de la ressource est très généralement au pluriel
@Produces("application/json") // Format incontournable en REST
public class MonPremierRestController {

	@GET
	@Path("/{id}")
	public MonPremierRestDto getMonPremierRestBean(@PathParam("id") Long id) {
		System.out.println("La méthode de récupération a été appelée avec l'id " + id);
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId(id);
		monPremierRestDto.setName("Philippe HASSAN");
		return monPremierRestDto;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMonPremierRestBeanPlain(@PathParam("id") Long id) {
		System.out.println("La méthode de récupération a été appelée avec l'id " + id);
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId(id);
		monPremierRestDto.setName("Philippe HASSAN");
		return monPremierRestDto.toString();
	}

	
	@POST
	@Path("/")
	public MonPremierRestDto post(MonPremierRestDto monPremierRestDto) {
		System.out.println("J'ai récupéré un Dao avec l'id : " + monPremierRestDto.getId() + " et le nom : "
				+ monPremierRestDto.getName());
		return monPremierRestDto;
	    //dans le postman en methode POST le url est http://localhost:8080/poe-java-av-jdbc/clients/42
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteMonPremierRestBean(@PathParam("id") Long id) {
	    System.out.println("La méthode de suppression a été appelée avec l'id " + id);
	    //dans le postman en methode DELETE le url est http://localhost:8080/poe-java-av-jdbc/clients/42
	}

}