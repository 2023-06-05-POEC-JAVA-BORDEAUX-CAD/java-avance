package fr.maboite.exercice;

public class threadRunnable implements Runnable {

  @Override
  public void run(){
    System.out.println("Démarrage thread Runnable");
    System.out.println("Fin thread Runnable");
  }

   public static void main() {

  Thread threadRunnable = new Thread(new threadRunnable());
  threadRunnable.start();
   Runnable runnable = new threadRunnable();

    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(runnable);
      thread.start();
    }
}}