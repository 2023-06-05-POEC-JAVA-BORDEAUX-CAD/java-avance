package fr.boite.philippe;

public abstract class Fruit {
	
	private String name;
	
	public Fruit(String name) {
		this.setName(name);
	}
	
	public abstract void taste();
	public abstract int getSize();
	public abstract boolean hasSend();
	
	public void miam() {
		System.out.println("miam manger 5 fruits et légumes par jour : " + getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
