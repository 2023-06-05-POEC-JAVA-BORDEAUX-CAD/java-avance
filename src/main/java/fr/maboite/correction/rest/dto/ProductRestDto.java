package fr.maboite.correction.rest.dto;

import fr.maboite.correction.jpa.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductRestDto {

	private Long id;

	@NotBlank
	private String name;

	@NotNull
	@Positive
	private Integer price;

	public ProductRestDto() {

	}

	public ProductRestDto(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Product toEntity() {
		Product entity = new Product();
		entity.setId(this.id);
		entity.setName(this.name);
		entity.setPrice(this.price);
		return entity;
	}

}
