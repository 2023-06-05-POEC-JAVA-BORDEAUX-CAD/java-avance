package fr.mesvetements;

public class Client {

	private String prenom;
	private String nom;
	private Haut haut;
	private Bas bas;

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Haut getHaut() {
		return haut;
	}

	public void setHaut(Haut haut) {
		this.haut = haut;
	}

	public Bas getBas() {
		return bas;
	}

	public void setBas(Bas bas) {
		this.bas = bas;
	}
	
	public  void parle() {
		System.out.println("Je m'appelle " + this.prenom  + " " + this.nom );
		System.out.println("Je porte : ");
		if(this.haut!= null) {
			this.haut.affiche();
		}
		if(this.bas!= null) {
			this.bas.affiche();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		Client jose = new Client();
		jose.setPrenom("José");
		jose.setNom("Pas");
		Tshirt tshirtSteven = new Tshirt("Steven Seagall");
		tshirtSteven.setNom("T shirt blanc");
		jose.setHaut(tshirtSteven);
		Short superShort = new Short();
		superShort.setNom("super short");
		jose.setBas(superShort);
		jose.parle();
		
		System.out.println("\r\n");

		Client sarah = new Client();
		sarah.setPrenom("Sarah");
		sarah.setNom("Croche");
		Chemise chemiseAPois = new Chemise(Motif.A_POIS);
		chemiseAPois.setNom("Chemise rouge");
		sarah.setHaut(chemiseAPois);
		Jupe jupeClassique = new Jupe();
		jupeClassique.setNom("jupe classique");
		sarah.setBas(jupeClassique);
		sarah.parle();
		
		System.out.println("\r\n");


		Client manon = new Client();
		manon.setPrenom("Manon");
		manon.setNom("Mahoui");
		Tshirt tshirtNoir = new Tshirt("Chuck Norris");
		tshirtNoir.setNom("T shirt noir");
		manon.setHaut(tshirtNoir);
		Pantalon pantalonNoir = new Pantalon();
		pantalonNoir.setNom("pantalon noir");
		manon.setBas(pantalonNoir);
		manon.parle();
	}

	

}
