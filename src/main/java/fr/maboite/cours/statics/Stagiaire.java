package fr.maboite.cours.statics;

public class Stagiaire {

	private int age;
	private int taille;
	private static int nombreDeStagiairesCrees = 0;
	
	public static final Stagiaire DEFAULT_STAGIAIRE = new Stagiaire();

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public static int getNombreDeStagiairesCrees() {
		return nombreDeStagiairesCrees;
	}
	
	public static int compareStagiaires(Stagiaire stagiaire1, Stagiaire stagiaire2) {
		return 1;
	}

	public Stagiaire() {
		nombreDeStagiairesCrees++;
	}
	
	public void apprend() {
		System.out.println("J'ai appris mon cours, avec mes : " + nombreDeStagiairesCrees + " collègues.");
	}

}
