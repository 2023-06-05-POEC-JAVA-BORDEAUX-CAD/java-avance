package fr.maboite.cours.thread;

public class MonThreadQuiAfficheSalut extends Thread {

	private int nombreDeRepetitions;

	private String prenom;

	public int getNombreDeRepetitions() {
		return nombreDeRepetitions;
	}

	public void setNombreDeRepetitions(int nombreDeRepetitions) {
		this.nombreDeRepetitions = nombreDeRepetitions;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public void run() {
		for (int i = 0; i < nombreDeRepetitions; i++) {
			System.out.println("salut " + prenom);
		}

	}

}
