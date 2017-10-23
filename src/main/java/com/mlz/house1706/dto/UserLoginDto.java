package com.mlz.house1706.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.codec.digest.DigestUtils;

public class UserLoginDto {
	private Integer id;
	@Pattern(regexp="^\\w{6,20}$")
	private String username;
	@Size(min=6)
	private String password;
	@Size(min=4,max=4)
	private String code;

	private String relName;
	private String ipAddress;
	


	public UserLoginDto() {
	}
	
	public UserLoginDto(String username, String password, String code, String ipAddress) {
		this.username = username;
		this.password =  DigestUtils.md5Hex(password);
		this.code = code;
		this.ipAddress = ipAddress;
	}

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getCode() {
		return code;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = DigestUtils.md5Hex(password);
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public Integer getId() {
		return id;
	}

	public String getRelName() {
		return relName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRelName(String realName) {
		this.relName = realName;
	}
	
}
