package fr.boite.rest.dto;

public class ErrorRestImmutableDto {
	private final String type;
	private final String title;
	private final String detail;

	public ErrorRestImmutableDto(String type, String title, String detail) {
		this.type = type;
		this.title = title;
		this.detail = detail;
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getDetail() {
		return detail;
	}
}
