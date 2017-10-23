package com.mlz.house1706.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Integer id;
	
	private String username;
	
	private String password;
	private String realName;

	private String tel;

	private Boolean isAdmin = false;

	public User() {
	}
	public User(Integer id) {
		 this.id=id;
		
	}
	public User(String username, String password, String realName, String tel, Boolean isAdmin) {
		this.username = username;
		this.password = DigestUtils.md5Hex(password);
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
		this.password = DigestUtils.md5Hex(password);
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", realName=" + realName
				+ ", tel=" + tel + ", isAdmin=" + isAdmin + "]";
	}
}
