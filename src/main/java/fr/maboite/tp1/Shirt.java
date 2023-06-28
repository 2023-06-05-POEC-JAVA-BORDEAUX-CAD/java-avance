package fr.maboite.tp1;

public class Shirt extends Top{

	private final String type = "Trousers";

	public Shirt() {}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String describ = super.getDescription();
		return describ + "\ntype : " + this.type;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}
	
	
	public String getType() {
		return type;
	}
}
