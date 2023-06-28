package fr.maboite.tp1;

public class Top implements ICloth {

	String name;
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "designation : " + this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
