package fr.jpa;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrdersFaceBean {
  
  @Inject
  private OrdersDao ordersDao;

  public void sauvegarde(){
    Orders orders = new Orders();
    orders.setTypePresta("Formation");
    orders.setDesignation("React Avancé");
    orders.setClientId(2); 
    orders.setNbDays(3); 
    orders.setUnitPrice(1000);
    orders.setState(2);
    ordersDao.save(orders);
  }
  
}
