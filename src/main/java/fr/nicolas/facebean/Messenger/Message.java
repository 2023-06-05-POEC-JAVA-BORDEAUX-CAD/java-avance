package fr.nicolas.facebean.Messenger;

public class Message {

	private String message;
	private Integer id;
	
	public Message() {}
	
	public Message(String message, Integer id) {
		this.message = message;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public Integer getId() {
		return id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
