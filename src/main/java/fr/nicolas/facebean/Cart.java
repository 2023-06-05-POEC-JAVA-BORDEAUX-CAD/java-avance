package fr.nicolas.facebean;

import java.io.Serializable;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer productsNumber;
	
	public Cart() {
		this.productsNumber=0;
	}

	public Integer getProductsNumber() {
		return productsNumber;
	}

	public void setProductsNumber(Integer productsNumber) {
		this.productsNumber = productsNumber;
	};
	
	public void addProduct() {
		this.productsNumber++;
	}
	
}
