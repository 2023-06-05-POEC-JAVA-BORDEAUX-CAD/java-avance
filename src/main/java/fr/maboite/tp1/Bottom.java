package fr.maboite.tp1;

public class Bottom implements ICloth {

	String name;
	Boolean isShort;
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(this.name);
		System.out.println(this.isShort);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getBotLenght() {
		return isShort;
	}

	public void setBotLenght(Boolean isShort) {
		this.isShort = isShort;
	}

}
