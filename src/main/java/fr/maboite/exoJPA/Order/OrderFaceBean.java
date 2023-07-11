package fr.maboite.exoJPA.Order;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrderFaceBean{
	
	@Inject
	private OrderJpaDao orderJpaDao;
	
	@Inject
	private ServiceJpa orderService;

	public void sauvegarder()
	{
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setClientId(8);
		orderEntity.setDesignation("Angular");
		orderEntity.setTypePresta("Formation");
		OrderEntity savedOrder = orderService.save(orderEntity);
		
		OrderEntity loadedOrder = orderService.load(savedOrder.getId());
		System.out.println("En base, j'ai un order dont la désignation vaut : " 
				+ loadedOrder.getDesignation() + " pour l'id : " + loadedOrder.getId());
	}

}