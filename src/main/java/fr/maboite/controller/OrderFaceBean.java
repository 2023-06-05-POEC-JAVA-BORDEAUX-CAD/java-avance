package fr.maboite.correction.jsf.controller;

import fr.maboite.correction.jpa.dao.OrderJpaDao;
import fr.maboite.correction.jpa.model.Order;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrderFaceBean {

	private int id;

	@Inject
	private OrderJpaDao orderDao;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String saveOrder() {
		System.out.println("TRIGGER SAVE ORDER ORDERFACEBEAN");
		Order order = new Order( "typePresta",  "designation",  2,  7,  1200,  1);
System.out.println(order);
		orderDao.save(order);
		System.out.println(order);

		return "success";
	}

	public void onLoad() {
		System.out.println("trigger");
		
		orderDao.find(id);
	}




	
	
}
