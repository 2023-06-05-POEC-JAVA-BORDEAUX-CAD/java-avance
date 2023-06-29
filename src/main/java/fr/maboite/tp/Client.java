package fr.maboite.tp;

public class Client {

	//Propriétés
	private String nom;
	private String prenom;
	private Haut haut;
	private Bas bas; 
	
	//Constructeur
	public Client(String nom, String prenom, Haut haut, Bas bas) {
		this.nom = nom;
		this.prenom = prenom;
		this.haut = haut;
		this.bas = bas;
	}
	
	//Getters
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public Haut getHaut() {
		return this.haut;
	}
	
	public Bas getBas() {
		return this.bas;
	}
	
	//Setters
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setHaut(Haut haut) {
		this.haut = haut;
	}
	
	public void setBas(Bas bas) {
		this.bas = bas;
	}
	
	//Méthode
	public void parle() {
		System.out.println("Bonjour, je m'appelle " + this.prenom + this.nom + " , et je porte :" + this.haut + " & " + this.bas);
	}
	
}

public class Heritage {
    public static void main(String[] args) {
        Client client1 = new Client("Dufour", "Géraldine", "Tshirt", "Jupe");
        
        
        
        client1.parle();
    }
}
