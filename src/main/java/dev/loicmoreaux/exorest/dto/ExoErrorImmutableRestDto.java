package dev.loicmoreaux.exorest.dto;

public class ExoErrorImmutableRestDto {
	private final String type;
	private final String title;
	private final String detail;
	
	/**
	 * @param type
	 * @param title
	 * @param detail
	 */
	public ExoErrorImmutableRestDto(String type, String title, String detail) {
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
