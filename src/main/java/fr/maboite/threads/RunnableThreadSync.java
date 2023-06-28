package fr.maboite.threads;

public class RunnableThreadSync implements Runnable {

	private int a;
	private int b;
	private int res;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			long alpha = (long)(Math.random() * 10000 )+1;
			Thread.sleep(alpha);
			res = a+b;
		} catch(InterruptedException e) {
			return;
		}
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

}
