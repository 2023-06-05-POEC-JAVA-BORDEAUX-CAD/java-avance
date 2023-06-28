package fr.maboite.tp1;

public class Bottom implements ICloth {

	String name;
	Boolean isShort;
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String isShortString = isShort? "Oui": "non";;
		return "designation : " + this.name + "\nBas court : " + isShortString;
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
