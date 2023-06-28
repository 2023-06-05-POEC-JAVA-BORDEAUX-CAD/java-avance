package fr.maboite.gabriel;

public class RandomRunnable implements Runnable {

	private int variable;

	public RandomRunnable(int variable) {
		this.variable = variable;

	}

	public RandomRunnable() {

	}

	@Override
	public void run() {

		try {

			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		variable = 2;
	}

	public int getValeur() {
		return this.variable;
	}

}
