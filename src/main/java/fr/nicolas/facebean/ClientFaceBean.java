package fr.nicolas.facebean;


import java.time.LocalDate;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFaceBean {

	private String name;
	private Boolean hasCart;
	private Integer cartAmount;
	private LocalDate lasdateTimeCart;
	
	public ClientFaceBean() {
		this.name = "Robert Barathéon";
		this.hasCart = true;
		this.cartAmount = 100;
		this.lasdateTimeCart = LocalDate.now();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getHasCart() {
		return hasCart;
	}

	public Integer getCartAmount() {
		return cartAmount;
	}

	public void setHasCart(Boolean hasCart) {
		this.hasCart = hasCart;
	}

	public void setCartAmount(Integer cartAmount) {
		this.cartAmount = cartAmount;
	}

	public LocalDate getLasdateTimeCart() {
		return lasdateTimeCart;
	}

	public void setLasdateTimeCart(LocalDate lasdateTimeCart) {
		this.lasdateTimeCart = lasdateTimeCart;
	}

	
}
