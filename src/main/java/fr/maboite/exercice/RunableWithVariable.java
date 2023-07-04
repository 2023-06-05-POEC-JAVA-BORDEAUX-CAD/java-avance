package fr.maboite.exercice;

public class RunableWithVariable implements Runnable {

  private int nombre = 2;

  public int runableWithVariable() {
    return nombre;    
  }

  @Override
  public void run(){
    try {

      Thread.sleep(5000);
    } catch (Exception e) {
      e.printStackTrace();
    }
  nombre = 25;
  }
  public int getNombre() {
    return this.nombre;
  }
  public void setNombre(int nombre) {
    this.nombre = nombre;
  }
}
