package fr.maboite.jpa;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class OrderJpaService {

	@Inject
	private OrderDao orderdao;
	
	
	/**
	 * Sauvegarde order, mais ne le modifie pas.Renvoie une instance
	 * qui correspond à Orderjpa en base de données.
	 * @param orderjpa
	 * @return
	 */
	public OrderJpa save(OrderJpa orderjpa) {
		System.out.println("Sauvegarde de : " +orderjpa);
		return this.orderdao.save(orderjpa);
		
	}
	/**
	 * Charge (récupere) un order en fonction de l'id
	 * @param id
	 * @return
	 */
	public OrderJpa load(Integer id) {
		System.out.println("Chargement de order avecc id : " +id);
		OrderJpa orderjpa=this.orderdao.load(id);
		if(orderjpa==null) {
			System.out.println("élement non trouvé");
		}else {
			System.out.println("élement trouvé");
		}
		return orderjpa;
		
	}
}
