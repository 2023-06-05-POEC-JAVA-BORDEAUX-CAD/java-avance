package fr.maboite.correction.pojojsonservlet.dao;


													    // Ces lignes sont des instructions d'importation 
													    // qui permettent d'utiliser les classes nécessaires dans le code. 
import java.util.HashMap;
import java.util.Map;

import fr.maboite.correction.pojojsonservlet.pojo.Pojo;
import jakarta.ejb.Stateless;



/**
 * Data Access Object: classe permettant 
 * d'accéder en lecture ou écriture au référentiel 
 * de données des Pojos (ici, une simple Map)
 */


@Stateless  											// L'annotation "@Stateless" est une annotation EJB qui spécifie que la classe ne conserve pas d'état entre les appels de méthode. 
public class PojoDao /*implements PojoDaoInterface*/ { 		// la classe PojoDao : fournit des méthodes pour accéder aux objets Pojo stockés dans une HashMap.
													    // la classe PojoDao est un composant Stateless EJB (Enterprise JavaBean), une classe d'entreprise sans état.
													    // De plus, la classe implémente l'interface PojoDaoInterface.
	
	private Map<Integer, Pojo> pojos = new HashMap<>(); // Cette ligne déclare une variable pojos qui est une Map (une interface de collection) associant des entiers (Integer) à des objets Pojo.
														// Elle est initialisée avec une nouvelle instance de HashMap<Integer, Pojo>(), qui est une implémentation de l'interface Map basée sur une table de hachage.
	
		public PojoDao() { 								// Ceci est le constructeur de la classe "PojoDao"
												    	// Un constructeur est une méthode spéciale qui est appelée lorsqu'une instance de la classe est créée. Le code à l'intérieur du constructeur est exécuté pour initialiser l'objet. 
												    	// Dans cet exemple, le constructeur est vide, ce qui signifie qu'il ne contient pas de code supplémentaire.	
			
		
														/* Ces lignes créent une nouvelle instance de la classe Pojo appelée pojo1 à l'aide de l'opérateur new. Ensuite, 
														 * les méthodes setter setId, setName et setValid sont utilisées pour définir les valeurs des propriétés de l'objet pojo1. 
														 * Finalement, l'objet pojo1 est ajouté à la Map pojos à l'aide de la méthode put, où son ID est utilisé comme clé.
														 */
		Pojo pojo1 = new Pojo();
		pojo1.setId(1);
		pojo1.setName("Hey!");
		pojo1.setValid(Boolean.TRUE);
		this.pojos.put(pojo1.getId(), pojo1);
		
														/* Les blocs de code similaires suivants créent deux autres instances de Pojo, pojo2 et pojo3, 
														 * et les ajoutent à la Map pojos avec leurs clés respectives. 
														 */
		
		Pojo pojo2 = new Pojo();
		pojo2.setId(2);
		pojo2.setName("Hé bien!");
		pojo1.setValid(Boolean.FALSE);
		this.pojos.put(pojo2.getId(), pojo2);

		Pojo pojo3 = new Pojo();
		pojo3.setId(3);
		pojo3.setName("Voilà un POJO");
		pojo1.setValid(Boolean.TRUE);
		this.pojos.put(pojo3.getId(), pojo3);
	}
		/*@Override*/
														// Cette méthode "getPojo" est une implémentation de la méthode définie dans l'interface PojoDaoInterface. 
		public Pojo getPojo(Integer id) { 				// La méthode prend un id en paramètre, 
		return this.pojos.get(id); 						// et renvoie le Pojo correspondant à cet ID à partir de la Map pojos en utilisant la méthode get.
	}
	
}


														/*La méthode getPojo est une méthode qui permet d'obtenir un objet Pojo à partir de la classe PojoDao. Voici une explication simple pour un enfant de 5 ans :
														
														Imaginons que tu as une boîte spéciale appelée PojoDao qui contient plusieurs objets Pojo à l'intérieur. Chaque objet Pojo a une étiquette avec un numéro dessus.
														
														Maintenant, supposons que tu veuilles obtenir un objet Pojo spécifique de cette boîte en utilisant son numéro d'étiquette. 
														
														Tu peux demander à la boîte PojoDao de te donner l'objet Pojo correspondant au numéro que tu lui donnes.
														
														La méthode getPojo est comme une personne qui travaille à la boîte PojoDao. Lorsque tu lui donnes un numéro d'étiquette (appelé id), elle,
														
														vérifie dans la boîte PojoDao et te donne l'objet Pojo qui correspond à ce numéro. Ainsi, tu peux obtenir l'objet Pojo que tu veux de la boîte.
														
														Maintenant, tu peux utiliser cet objet Pojo pour faire ce que tu veux avec lui, comme le lire, jouer avec ou faire d'autres choses amusantes !
														
														En résumé, la méthode getPojo permet d'obtenir un objet Pojo spécifique à partir de la classe PojoDao en utilisant son numéro d'étiquette.*/