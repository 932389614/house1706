package com.mlz.house1706.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="tb_login_log")
public class Login_Log implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="loginid")
	private Integer id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column(nullable=false,name="ipaddr")
	private String address;
	@Column(nullable=false,name="logdate")
	private Date loginDate;
	
	public Login_Log() {
	}


	public Login_Log(User user, String address, Date loginDate) {
		this.user = user;
		this.address = address;
		this.loginDate = loginDate;
	}


	public Integer getId() {
		return id;
	}


	public User getUser() {
		return user;
	}


	public String getAddress() {
		return address;
	}


	public Date getLoginDate() {
		return loginDate;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	
}
