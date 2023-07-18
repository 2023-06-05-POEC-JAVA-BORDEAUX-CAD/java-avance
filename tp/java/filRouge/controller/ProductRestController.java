package filRouge.controller;

import java.util.List;

import filRouge.Dto.ProductDto;
import filRouge.Dto.ProductDto;
import filRouge.model.ErrorMessage;
import filRouge.model.Product;
import filRouge.model.Product;
import filRouge.service.ProductService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("/products")
@Produces("application/json")
public class ProductRestController {
	
	@Inject
	private ProductService productService;

	@GET
	@Path("/{id}")
	public Response getProduct(@PathParam("id") int id) {

		System.out.println("declenchement avec recup id " + id);
		if (id < 0) {
			ErrorMessage erreur = new ErrorMessage();
			erreur.setMessage("erreur !!!");
			return Response.status(Status.NOT_FOUND).entity(erreur).build();

		}
		Product product = productService.load(id);
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		

		// return orderDto;
		return Response.ok(productDto).header("reponse", "ca marche").build();

	}

	@GET
	@Path("/")
	public Response getAllProducts() {
		List<Product> orders = productService.findAll();
		return Response.ok(orders).header("reponse", "ca marche").build();

	}
	@DELETE
	@Path("/delete/{id}")
	public void delete(@PathParam("id") int id) {
		System.out.println("trigger delete");
		productService.deleteById(id);

	}
	
}
