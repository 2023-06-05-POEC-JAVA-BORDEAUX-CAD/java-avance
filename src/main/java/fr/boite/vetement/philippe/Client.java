/**
 * 
 */
package fr.boite.vetement.philippe;

/**
 * 
 */
public class Client {
	private String nom;
	private String prenom;
	 private String haut;
	 private String bas;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/* Constructeur du client */
	
    public Client(String haut, String bas, String nom, String prenom) {
        this.haut = haut;
        this.bas = bas;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    
    /* Getter et Setter */
    
	// Getter et Setter pour l'attribut nom
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Getter et Setter pour l'attribut prenom
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	/* Méthode parle() qui utilise affiche() de haut et bas */
	 public void parle() {
	        System.out.println("Je m'appelle " + prenom + " " + nom);
	        System.out.println("Haut : " + haut);
	        System.out.println("Bas : " + bas);
	    }
	
	// Méthode pour afficher les caractéristiques du haut
	    @SuppressWarnings("unused")
		private void afficheHaut() {
	        System.out.println("Caractéristiques du haut : " + haut);
	    }

	    // Méthode pour afficher les caractéristiques du bas
	    @SuppressWarnings("unused")
		private void afficheBas() {
	        System.out.println("Caractéristiques du bas : " + bas);
	    }
	    
	
}
