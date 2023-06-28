package fr.maboite.exercice;

class MyThread extends Thread {
	int instance;

	public MyThread(int num) {
		this.instance = num;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("thread: " + this.instance);
		}
	}
}

class MyRunnable implements Runnable {
	int instance;

	public MyRunnable(int num) {
		this.instance = num;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("runnable: " + this.instance);
		}
	}

}

public class ExoThread {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("anonymous runnable");
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				thread = new MyThread(i);
				thread.start();
			} else {
				runnable = new MyRunnable(i);
				thread = new Thread(runnable);
				thread.start();
			}
		}
	}
}