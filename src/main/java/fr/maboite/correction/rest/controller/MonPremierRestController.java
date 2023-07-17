package fr.maboite.correction.rest.controller;

import fr.maboite.correction.rest.dto.MonPremierRestDto;
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
@Produces(MediaType.APPLICATION_JSON) // Format incontournable en REST
public class MonPremierRestController {

	@GET
	@Path("/{id}") // L’URL finale sera : application + classe + méthode
	public MonPremierRestDto getMonPremierRestBean(@PathParam("id") Long id) {// ← Correspond à {id}
		System.out.println("La méthode de récupération a été appelée avec l'id " + id);
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId(id);
		monPremierRestDto.setName("Salut!");
		return monPremierRestDto;
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
	public MonPremierRestDto post(MonPremierRestDto monPremierRestDto) {
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