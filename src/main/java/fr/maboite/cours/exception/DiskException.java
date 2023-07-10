package fr.maboite.cours.exception;

public class DiskException extends RuntimeException {
	
	private String disqueEnEchec;

	public String getDisqueEnEchec() {
		return disqueEnEchec;
	}

	public void setDisqueEnEchec(String disqueEnEchec) {
		this.disqueEnEchec = disqueEnEchec;
	}
	
	

}
