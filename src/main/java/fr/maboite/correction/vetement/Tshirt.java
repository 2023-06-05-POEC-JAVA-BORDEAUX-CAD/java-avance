package fr.maboite.correction.vetement;

public class Tshirt extends Haut {
	
	private String logo;
	
	public Tshirt(String logo) {
		this.logo = logo;
	}

	@Override
	public void affiche() {
		super.affiche();
		System.out.println("avec super logo " + logo);
	}

}
