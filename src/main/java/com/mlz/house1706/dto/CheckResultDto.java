package com.mlz.house1706.dto;

public class CheckResultDto {
	private boolean valid;
	private String message;
	private String picture;
	private String username;
	
	public CheckResultDto() {
	}
	public CheckResultDto(boolean valid, String message, String picture,String username) {
		this.valid = valid;
		this.message = message;
		this.picture = picture;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isValid() {
		return valid;
	}
	public String getMessage() {
		return message;
	}
	public String getPicture() {
		return picture;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}
