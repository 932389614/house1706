package com.mlz.house1706.domain;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name="tb_user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private Integer id;
	@Column(nullable=false,length=20,unique=true)
	private String username;
	@Column(nullable=false,length=32)
	private String password;
	private String realName;
	@Column(length=11)
	private String tel;
	private Boolean isAdmin;

	public User() {
	}
	public User(String username, String password, String realName, String tel, Boolean isAdmin) {
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.tel = tel;
		this.isAdmin = isAdmin;
	}
	public Integer getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRealName() {
		return realName;
	}
	public String getTel() {
		return tel;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
