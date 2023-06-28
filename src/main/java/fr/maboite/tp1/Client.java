package fr.maboite.tp1;

public class Client {

	String name;
	String firstName;
	Top top;
	Bottom bottom;
	
	public Client() {}
	
	
	public void speak() {
		String bottomDescrib = "Mon bas est le suivant : \n" + this.bottom.getDescription();
		String topDescrib = "Mon haut est le suivant : \n" + this.top.getDescription();
		System.out.println(topDescrib +"\n\n"+ bottomDescrib); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Top getTop() {
		return top;
	}

	public void setTop(Top top) {
		this.top = top;
	}

	public Bottom getBottom() {
		return bottom;
	}

	public void setBottom(Bottom bottom) {
		this.bottom = bottom;
	}
	
}
