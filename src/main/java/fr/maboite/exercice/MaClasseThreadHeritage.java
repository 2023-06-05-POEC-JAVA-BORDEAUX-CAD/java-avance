package fr.maboite.exercice;

public class MaClasseThreadHeritage extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("Ceci est un thread heritage");
		}
	}
	
}
