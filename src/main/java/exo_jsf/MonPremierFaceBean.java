package exo_jsf;

import java.time.LocalDateTime;

import fr.maboite.fabien.tpjsf.OrderDao;
import fr.maboite.fabien.tpjsf.jpamodel.Order;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MonPremierFaceBean {

	@Inject
	private OrderDao orderDao;
	
	private String message = "Ce message vient du contrôleur";

	public String getMessage() {
		return LocalDateTime.now().toString();
	}
	
	public String getCoucou() {
		return "Salut ! ";
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void sauvegardeOrder() {
		Order order = new Order();
		order.setType_presta("Formation Test");
		order.setDesignation("JavaScript");
		order.setClient_id(1);
		orderDao.save(order);
	}

}