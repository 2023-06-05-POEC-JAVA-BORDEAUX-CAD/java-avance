package fr.boite.philippe;

public class Strawberry extends Fruit {

	public Strawberry(String name) {
		super("fraise");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void taste() {
		// TODO Auto-generated method stub
		System.out.println("le gout est plutot sucré");

	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean hasSend() {
		// TODO Auto-generated method stub
		return false;
	}

}
