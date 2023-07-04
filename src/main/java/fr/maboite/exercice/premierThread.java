package fr.maboite.exercice;

public class premierThread {
  public static void main(String[] args) { 

  System.out.println("Démarrage premierThread");
  System.out.println("Fin premierThread");
  threadSecondaire threadSecondaire = new threadSecondaire();
   threadSecondaire.start();

  threadRunnable threadRunnable = new threadRunnable();
  Thread threadR =new Thread(threadRunnable);
 threadR.start();

  RunableWithVariable runableWithVariable = new RunableWithVariable();
  Thread threadV =new Thread(runableWithVariable);
  threadV.start();
  try {
    threadV.join();
} catch (InterruptedException e) {
  // TODO Auto-generated catch block
    e.printStackTrace();
}

  System.out.println(runableWithVariable.getNombre());
    
}}

