package fr.boite.philippe;

public class Apple extends Fruit implements PeelFruit{

	public Apple() {
		super("pomme");
	}
	
	
	@Override
	public void taste() {
		// TODO Auto-generated method stub
		System.out.println("la pomme à un gout sucré");
		// accer super class
		
		super.miam();
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasSend() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isPeeled() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String getSkinType() {
		// TODO Auto-generated method stub
		return "lisse";
	}

	
	

}