package fr.maboite.exercice;


public class UneClasseQuiLanceDesThreads {
	public static void main(String[] args) {
		System.out.println("on va lancer des threads");
		
		MaClasseThreadHeritage MaClasseThreadHeritage = new MaClasseThreadHeritage();
		MaClasseThreadHeritage.start();
		
		new Thread(new MaClasseRunnableImplement()).start();
		
		while(true){
			System.out.println("c'est le main");
		}
	}
}
