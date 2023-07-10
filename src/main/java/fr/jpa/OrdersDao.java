package fr.jpa;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrdersDao {

  @PersistenceContext
  protected EntityManager entityManager;

 public void save(Orders order) {
  this.entityManager.merge(order);
 }
  
}
