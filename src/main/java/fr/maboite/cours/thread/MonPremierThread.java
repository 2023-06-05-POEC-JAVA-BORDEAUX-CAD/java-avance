package fr.maboite.cours.thread;

public class MonPremierThread {

	public static void main(String[] args) {
		
		//Première manière de commencer un nouveau Thread en Java : en utilisant une classe qui hérite de Thread
		MonThreadQuiAfficheSalut monThreadQuiAfficheSalut = new MonThreadQuiAfficheSalut();
		monThreadQuiAfficheSalut.setNombreDeRepetitions(100);
		monThreadQuiAfficheSalut.setPrenom("Jean");
		monThreadQuiAfficheSalut.start();
		
		//Deuxième manière de commencer un nouveau Thread en Java :
		//En construisant une instance de Thread qui prend en argument une instance de Runnable
		MonRunnableQuiAfficheAuRevoir monRunnableQuiAfficheAuRevoir = new MonRunnableQuiAfficheAuRevoir();
		Thread threadAvecRunnable = new Thread(monRunnableQuiAfficheAuRevoir);
		threadAvecRunnable.start();
		
		while(true) {
			System.out.println("Thread main");
		}
		
	}
	
}
