package fr.maboite.correction.vetement;

public class Chemise extends Haut {
	
	private Motif motif;
	
	public Chemise(Motif motif) {
		this.motif = motif;
	}

	@Override
	public void affiche() {
		super.affiche();
		System.out.println("avec un motif " + motif);
	}

}
