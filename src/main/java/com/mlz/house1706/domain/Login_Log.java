package com.mlz.house1706.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tb_login_log")
public class Login_Log implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loginid")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "ipaddr")
	private String ipAddress;
	@Column(name = "logdate")
	private Date loginDate;

	public Login_Log() {

	}

	public Login_Log(User user, String ipAddress, Date loginDate) {
		this.user = user;
		this.ipAddress = ipAddress;
		this.loginDate = loginDate;
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public String getAddress() {
		return ipAddress;
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
		this.ipAddress = address;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

}
