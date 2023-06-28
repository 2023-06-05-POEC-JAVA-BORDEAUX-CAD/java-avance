package fr.maboite.exercice;



	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	public class ThreadJoin {

	  public static void main(String[] args) {
	    DateFormat df = new SimpleDateFormat("HH:mm:ss");
	    Thread thread1 = new Thread(new MonRunnable(1000));
	    Thread thread2 = new Thread(new MonRunnable(2000));
	    Thread thread3 = new Thread(new MonRunnable(6000));

	    thread1.start();
	    System.out.println(df.format(new Date()) + " debut thread1");
	    
	    thread2.start();
	    System.out.println(df.format(new Date()) + " debut thread2");
	    
	    thread3.start();
	    System.out.println(df.format(new Date()) + " debut thread3");
	    
	    try {	    
	      thread2.join();
	    } catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
	    System.out.println(df.format(new Date()) + " fin thread2");
	    
	    try {
	      thread3.join();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }

	    System.out.println(df.format(new Date()) + " fin thread3");

	    try {
	      thread1.join();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }

	    System.out.println(df.format(new Date()) + " fin");
	  }

	  private static class MonRunnable implements Runnable {

	    private long delai;

	    public MonRunnable(long delai) {
	      this.delai = delai;
	    }

	    @Override
	    public void run() {
	      try {
	        Thread.sleep(delai);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    }
	  }
	}