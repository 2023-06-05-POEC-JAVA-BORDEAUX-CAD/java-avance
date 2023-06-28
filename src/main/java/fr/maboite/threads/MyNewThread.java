package fr.maboite.threads;

public class MyNewThread extends Thread{

	String msg = "";
	public MyNewThread(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(msg);
		}
	}

}
