package fr.maboite.jpa2.order;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrderFaceBean {
	@Inject
	private OrderService orderService;

	public void save() {
		Order order = new Order();
		order.setTypePresta("Formation");
		order.setDesignation("Java Avance");
//		order.setClient_id(1);
		order.setNbDays(22);
		order.setUnitPrice(1000);
		order.setState(1);

		orderService.save(order);

	}

}
