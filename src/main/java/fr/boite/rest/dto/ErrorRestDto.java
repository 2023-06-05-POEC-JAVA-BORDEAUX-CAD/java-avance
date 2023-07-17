package fr.boite.rest.dto;

public class ErrorRestDto {
	private String type;
	private String titles;
	private String detail;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
