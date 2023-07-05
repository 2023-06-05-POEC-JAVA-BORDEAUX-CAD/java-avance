package fr.maboite.fabien;

public class ThreadMain {

    public void run() {
        // j'execute le code ??
        System.out.println("Je suis en cours d'exécution.");
    }

    public static void main(String[] args) {
        // Création et démarrage d'une instance de MonThread
    	Thread monThread = new Thread();
        monThread.start();

        MonThreadAfficheAutre t= new MonThreadAfficheAutre();     
//        Thread y =new Thread(t);
//        y.start();
        // Le reste du code dans la méthode main continue à s'exécuter
        System.out.println("Le thread principal toujours en cours.");
        
 
    }
}
