package tp.rest;

class CustomResponse {
	public int code;
	public String reason;

	public CustomResponse() {
	}

	public CustomResponse(int code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}