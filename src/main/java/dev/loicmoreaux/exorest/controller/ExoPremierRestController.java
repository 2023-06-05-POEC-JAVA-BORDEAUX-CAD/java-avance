package dev.loicmoreaux.exorest.controller;

import dev.loicmoreaux.exorest.dto.ExoErrorRestDto;
import dev.loicmoreaux.exorest.dto.ExoPremierRestDto;
import jakarta.ejb.Stateless;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;


@Stateless
@Path("/exoclients")
@Produces("application/json")
public class ExoPremierRestController {
	
	@GET
	public ExoPremierRestDto getPremierRestDto () {
		System.out.println("GET in progress...");
		ExoPremierRestDto premierRestDto = new ExoPremierRestDto();
		premierRestDto.setId(1);
		premierRestDto.setName("Hello World!");
		return premierRestDto;
	}
	
	@GET
	@Path("/{id}")
	public Response getPremierRestDtoById (@PathParam("id") Integer id) {
		if(id < 0) {
			ExoErrorRestDto errorRestDto = new ExoErrorRestDto();
			errorRestDto.setMessage("il ne peut pas exister d'id inférieur a zéro");
			
			return Response.status(Status.BAD_REQUEST).header("erreur", "id improbable").entity(errorRestDto).build();
		}
		
		System.out.println("GET in progress...");
		ExoPremierRestDto premierRestDto = new ExoPremierRestDto();
		premierRestDto.setId(id);
		premierRestDto.setName("Coucou!");
		System.out.println("création du pojo id : " + id);
		return Response.ok(premierRestDto).header("user-id", "1234").header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXV").build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPremierRestDtoTextPlain (@PathParam("id") Integer id) {
		System.out.println("GET text/plain in progress...");
		ExoPremierRestDto premierRestDto = new ExoPremierRestDto();
		premierRestDto.setId(id);
		premierRestDto.setName("C'est du text plain");
		return premierRestDto.toString();
	}
	
	@POST
	public ExoPremierRestDto post(@Valid ExoPremierRestDto premierRestDto) {
		System.out.println("J'ai récupéré un DTO avec id : " + premierRestDto.getId()
				+ ", nom : " + premierRestDto.getName());
		return premierRestDto;
	}
	
	@PUT
	public ExoPremierRestDto put(ExoPremierRestDto premierRestDto) {
		ExoPremierRestDto pojoRestDto = new ExoPremierRestDto(1, "mon pojo original");
		System.out.println("Mon pojo original, id : " + pojoRestDto.getId() + ", nom : " + pojoRestDto.getName());
		pojoRestDto.setId(premierRestDto.getId());
		pojoRestDto.setName(premierRestDto.getName());
		System.out.println("Mon pojo modifié, id : " + pojoRestDto.getId() + ", nom : " + pojoRestDto.getName());
		return pojoRestDto;
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		System.out.println("suppression du Pojo id : " + id);
		return Response.ok().build();
	}
	
}