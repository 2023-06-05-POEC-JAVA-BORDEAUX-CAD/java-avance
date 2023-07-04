package fr.boite.philippe;

public enum Day {
	MATIN(8), 
	MIDI(12), 
	APRESMIDI(15), 
	SOIR(22), 
	NUIT(2);
	
	private int hour;
	Day(int hour){
		this.setHour(hour);
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	

}
