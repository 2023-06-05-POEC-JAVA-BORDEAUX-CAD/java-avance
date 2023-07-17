package fr.maboite.jpa2.message;

public class ErrorMessage {
	private final long errorCode;
	private final String Message;

	public long getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return Message;
	}

	public ErrorMessage(long errorCode, String message) {
		super();
		this.errorCode = errorCode;
		Message = message;
	}

}
