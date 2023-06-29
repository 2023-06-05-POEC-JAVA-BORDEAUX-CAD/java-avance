/**
 * 
 */
package fr.maboite.ebru;

/**
 * @author ebruj
 *
 */
public class Client{
	
	
	
	private String nom;
	private String prenom;
	private Haut haut;
	private Bas bas;
	


	public  Client(String nom, String prenom) {
		
		this.nom = nom;
		this.prenom = prenom;
		
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	


		
		public void parle() {
		
	
		haut.affiche();
	
		bas.affiche();
		
		System.out.println("client porte un" + haut + "et" + "un" + bas);
		
		}
		

	}


