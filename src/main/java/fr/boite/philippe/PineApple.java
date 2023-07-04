package fr.boite.philippe;

public class PineApple extends Fruit implements PeelFruit {
	private boolean peeled = false;
	
	public PineApple() {
		super("ananas");
	}

	@Override
	public void taste() {
		// TODO Auto-generated method stub
		System.out.println("l'annanas a un gout acide");
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 2;
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
		return "piquante";
	}

}
