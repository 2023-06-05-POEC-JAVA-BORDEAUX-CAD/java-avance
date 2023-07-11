package fr.maboite.cours.exception;

public class ExceptionMain {

	public static void main(String[] args) throws Exception {
		Garage garage = new Garage();
		
		//Division avec une méthode qui renvoie une valeur 'spéciale' 
		//si une erreur s'est produite
		double calculeDivisionAParB = garage.calculeDivisionAParB(3, 4);
		if(calculeDivisionAParB == -1) {
			System.out.println("La division par 0 est impossible");
		}else {
			System.out.println("Division avec la méthode qui renvoie une valeur spéciale : ");
			System.out.println(calculeDivisionAParB);
		}
		
		//Division avec un try catch
		try {
			System.out.println("Division avec la méthode qui lance une exception avec try : ");
			double resultatDivision = garage.calculeDivisionAParBAvecException(4, 0);
			System.out.println(resultatDivision);
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		System.out.println("Division avec la méthode qui lance une exception sans try : ");
		double resultatDivision2 = garage.calculeDivisionAParBAvecException(4, 1);
		System.out.println("J'ai divisé par 0 !!!");
		
		
		
		System.out.println("J'essaie de récupérer une voiture");
		garage.getParNumeroImmatriculation("XXX-AA-545");
		
		try {
			garage.prepareDisque();
		}catch(DiskException e) {
			System.out.println("j'ai catch l'exception disk sur le disque : " + e.getDisqueEnEchec());
		}
		
	}

}
