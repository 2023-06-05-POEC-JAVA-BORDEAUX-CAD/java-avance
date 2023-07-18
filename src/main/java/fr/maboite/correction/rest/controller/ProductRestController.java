package fr.maboite.correction.rest.controller;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.model.Product;
import fr.maboite.correction.jpa.service.ProductService;
import fr.maboite.correction.rest.dto.ProductRestDto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * Contrôleur REST pour products
 */
@Stateless
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductRestController {

	@Inject
	private ProductService productService;


	@GET
	@Path("/{id}")
	public Response getJson(@PathParam("id") Long id) {
		//Appel du service pour récupérer
		Product product = this.productService.load(id);
		if (product == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		//product!=null
		return Response.ok(new ProductRestDto(product))
				.build();
	}


	@GET
	@Path("/")
	public Response getByName(@QueryParam("name") String name) {
		//Appel du service pour récupérer
		List<Product> products =  this.productService.findByName(name);
		
		List<ProductRestDto> dtos = new ArrayList<ProductRestDto>();
		for(Product product : products) {
			dtos.add(new ProductRestDto(product));
		}
		
		return Response.ok(dtos)
				.build();
	}


	@POST
	@Path("/")
	public Response post(@Valid ProductRestDto productRestDto) {
		
		if (productRestDto == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Product savedProduct = this.productService.save(productRestDto.toEntity());
		
		return Response.ok(new ProductRestDto(savedProduct))
				.build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		Product product = this.productService.load(id);
		if(product == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		this.productService.delete(id);
		return Response.status(Status.OK).build();
	}

}