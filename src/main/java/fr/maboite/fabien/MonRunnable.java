package fr.maboite.fabien;


public class MonRunnable implements Runnable {

    @Override
    public void run() {
        // Le code à exécuter dans le thread
        System.out.println("thread en cours d'exécution.");
    }

    public static void main(String[] args) {
        // Création d'une instance de MonRunnable
        MonRunnable monRunnable = new MonRunnable();

        // Création d'une instance de Thread en utilisant MonRunnable
        Thread thread = new Thread(monRunnable);

        // Démarrage de l'exécution du thread
        thread.start();

        // Le reste du code dans la méthode main continue à s'exécuter
        System.out.println("Le thread principal continue son exécution.");
    }
}