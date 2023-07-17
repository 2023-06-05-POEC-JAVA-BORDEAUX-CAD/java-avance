package fr.maboite.correction.rest.controller;

import java.util.Random;

import fr.maboite.correction.rest.dto.ErrorRestDto;
import fr.maboite.correction.rest.dto.MonPremierRestDto;
import jakarta.ejb.Stateless;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/prototype-clients") // Le nom de la ressource est très généralement au pluriel
@Produces(MediaType.APPLICATION_JSON) // Format incontournable en REST
public class MonPremierRestController {

	@GET
	@Path("/{id}") // L’URL finale sera : application + classe + méthode
	public Response getMonPremierRestBean(@PathParam("id") Long id) {// ← Correspond à {id}
		System.out.println("La méthode de récupération a été appelée avec l'id " + id);
		
		if(id < 0) {
			ErrorRestDto errorRestDto = new ErrorRestDto();
			errorRestDto.setType("Requête incorrecte");
			errorRestDto.setTitle("Id négatif");
			errorRestDto.setDetail("L'id fourni : " + id + " est négatif, ce qui est interdit.");
			
			return Response.status(Status.NOT_FOUND)
					.entity(errorRestDto).build();
		}
		
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId(id);
		monPremierRestDto.setName("Salut!");
		
		return Response.ok(monPremierRestDto)
				.header("au-fait", "Ca va")
				.header("en-vrai", "c'est dur")
				.build();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMonPremierRestBeanPlain(@PathParam("id") Long id) {// ← Correspond à {id}
		System.out.println("La méthode de récupération a été appelée avec l'id " + id);
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId(id);
		monPremierRestDto.setName("Salut!");
		return monPremierRestDto.toString();
	}

	@POST
	@Path("/")
	public MonPremierRestDto post(@Valid MonPremierRestDto monPremierRestDto) {
		if(monPremierRestDto.getId() == null) {
			monPremierRestDto.setId(new Random().nextLong());
		}
		
		System.out.println("J'ai récupéré un DTO avec l'id : "
				+ monPremierRestDto.getId()
				+ " et le nom : "
				+ monPremierRestDto.getName());
		return monPremierRestDto;
	}

	@DELETE
	@Path("/{id}") // L’URL finale sera : application + classe + méthode
	public void delete(@PathParam("id") Long id) {// ← Correspond à {id}
		System.out.println("La méthode de suppressions a été appelée avec l'id " + id);
	}

}