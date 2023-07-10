package fr.maboite.jpa;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

//Controller

@Named
@RequestScoped
public class OrderFaceBean {
	
	@Inject
	private OrderDao orderdao;
	
	 public String saveOrder() {
		 OrderJpa orderJpa = new OrderJpa();
		 
		 orderJpa.setDesignation("Atos");
		 orderdao.save(orderJpa);
		return "succes";
		
		 
		 
		 
	 }

}
