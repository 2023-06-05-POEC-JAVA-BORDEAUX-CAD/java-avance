package fr.maboite.exercice;

public class MyRunnableClass2 implements Runnable {
	
	String message = "Ceci est un message";
	int delay = (int) Math.floor(Math.random() * 10) + 1;
	
	public String getMessage(){
		return message;
	}
	
	public int getDelay(){
		return delay;
	}
	
	public void setMessage(String newMessage) {
		message = newMessage;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(delay * 1000);
			setMessage("Ceci est un message avec délai de " + this.getDelay() + " secondes");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
			
	}
}
