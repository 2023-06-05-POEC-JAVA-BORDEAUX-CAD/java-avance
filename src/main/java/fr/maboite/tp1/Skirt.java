package fr.maboite.tp1;

public class Skirt extends Bottom{

	private final String type = "Skirt";
	
	public Skirt() {}

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

	@Override
	public Boolean getBotLenght() {
		// TODO Auto-generated method stub
		return super.getBotLenght();
	}

	@Override
	public void setBotLenght(Boolean isShort) {
		// TODO Auto-generated method stub
		super.setBotLenght(isShort);
	}

	public String getType() {
		return type;
	}

	
	
	
}
