package fr.maboite.exercice;

public class TestJoinThread extends Thread{
	public static void main(String[] args) {
		System.out.println("Je lance mon test");
		
		TestJoinRunnable testJoinRunnable = new TestJoinRunnable();
		Thread testJoinThread = new Thread(testJoinRunnable);
	}
}