package fr.maboite.cours.statics;

import java.util.Collections;

public class StagiaireMain {

	public static void main(String[] args) {
		Stagiaire antoine = new Stagiaire();
		antoine.setAge(3);
		antoine.setTaille(190);
		antoine.apprend();
		
		Stagiaire fabien = new Stagiaire();
		antoine.apprend();
		fabien.apprend();
		
		System.out.println(Stagiaire.getNombreDeStagiairesCrees());
		
		//PisteAtterissage e1 = PisteAtterissage.INSTANCE;
				

	}
	
	public void faireApprendre(Stagiaire stagiaire) {
		if(stagiaire == null) {
			Stagiaire.DEFAULT_STAGIAIRE.apprend();
		}else {
			stagiaire.apprend();
		}
		
		Integer.parseInt(null);
		
		Collections.reverse(null);
		
	}

}
