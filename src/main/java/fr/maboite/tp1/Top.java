package fr.maboite.tp1;

public class Top implements ICloth {

	String name;
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(this.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
