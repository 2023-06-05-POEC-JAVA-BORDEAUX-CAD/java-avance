package fr.maboite.exercice;

public class threadSecondaire extends Thread {

  @Override
 public void run() {

  System.out.println("Début thread secondaire");
  System.out.println("Fin thread secondaire");
  
 }
}
