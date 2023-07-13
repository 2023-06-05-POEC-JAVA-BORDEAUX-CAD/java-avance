package fr.noellie.rest.controller;

import fr.noellie.rest.dto.MonPremierRestDto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/clients") // le nom de la ressource est très souvent au pluriel
@Produces(MediaType.APPLICATION_JSON) // format incontournable en REST
public class MonPremierRestController {
	@Inject
	MonPremierRestDto monPremierRestDtoFull;

	@GET
//	@Path("/json/{id}") // l'URL finale sera de format class+methode
	@Path("/{id}") // l'URL finale sera de format class+methode
	public MonPremierRestDto getMonPremierRestBeanInJson(@PathParam("id") String id) {
		System.out.println("La méthode de récupération a été appelée avec l'Id : " + id);
		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
		monPremierRestDto.setId((long)34);
		monPremierRestDto.setName("Salut!");
		return monPremierRestDto;
	}
	
//	@GET
//	@Path("/text_plain/{id}") // l'URL finale sera de format class+methode
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMonPremierRestBeanInTextPlain(@PathParam("id") String id) {
//		System.out.println("La méthode de récupération a été appelée avec l'Id : " + id);
//		MonPremierRestDto monPremierRestDto = new MonPremierRestDto();
//		monPremierRestDto.setId((long)34);
//		monPremierRestDto.setName("Salut!");
//		return monPremierRestDto.toString();
//	}
	
	@POST
	@Path("/")
	public MonPremierRestDto post(MonPremierRestDto monPremierRestDto) {
		System.out.println("J'ai récupéré un DTO avec l'id : " 
			+ monPremierRestDto.getId() 
			+ " et le nom " + monPremierRestDto.getName());
		
		return monPremierRestDto;
	}
	
	@PUT
	@Path("/")
	public MonPremierRestDto put(MonPremierRestDto monPremierRestDto) {
		System.out.println("J'ai ajouté un DTO avec l'id : " 
			+ monPremierRestDto.getId() 
			+ " et le nom " + monPremierRestDto.getName());
		
		return monPremierRestDto;
	}
	
//	@DELETE
//	@Path("/{id}")
//	public void deleteById(@PathParam("id") String id) {
//		monPremierRestDtoFull.deleteById(id);
//		System.out.println("Le DTO a bien été supprimé");
//	}

}