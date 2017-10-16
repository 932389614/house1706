package com.mlz.house1706.domain;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name="tb_province")
public class Province implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="provid")
	private Integer id;
	@Column(name="provname",nullable=false)
	private String name;
	
	public Province() {
	}

	public Province(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
