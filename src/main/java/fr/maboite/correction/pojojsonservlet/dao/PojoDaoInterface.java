package fr.maboite.correction.pojojsonservlet.dao; //Cette ligne définit le package dans lequel se trouve l'interface PojoDaoInterface. 
												   // Le code est organisé en packages pour structurer les classes en fonction de leur fonctionnalité ou de leur domaine.



import fr.maboite.correction.pojojsonservlet.pojo.Pojo; //   Cette ligne est une instruction d'importation qui permet d'utiliser la classe "Pojo" dans l'interface. 
														// "import fr.maboite.correction.pojojsonservlet.pojo.Pojo" importe la classe "Pojo" du package "fr.maboite.correction.pojojsonservlet.pojo."

														//  l'interface "PojoDaoInterface" déclare une seule méthode "getPojo",
														// qui doit être implémentée par les classes qui l'implémentent.


public interface PojoDaoInterface { // Cette ligne définit l'interface "PojoDaoInterface".
									/* Une interface en Java est un contrat qui spécifie les méthodes qu'une classe qui implémente cette interface doit fournir. 
									 * Dans ce cas, "PojoDaoInterface" est une interface qui déclare une seule méthode "getPojo".
									 */

	Pojo getPojo(Integer id); // Cette ligne déclare une méthode "getPojo" dans l'interface "PojoDaoInterface".
							  /* La méthode prend un paramètre id de type Integer et retourne un objet de type Pojo. 
							   * Cela signifie que toute classe qui implémente cette interface doit fournir une implémentation de cette méthode, 
							   * qui prendra un id en entrée et renverra l'objet Pojo correspondant à cet ID.
							   */

}