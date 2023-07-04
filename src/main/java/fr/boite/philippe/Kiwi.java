package fr.boite.philippe;

public class Kiwi extends Fruit implements PeelFruit {

	public Kiwi(String name) {
		super(name);
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

	@Override
	public boolean isPeeled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getSkinType() {
		// TODO Auto-generated method stub
		return "doux";
	}

}
