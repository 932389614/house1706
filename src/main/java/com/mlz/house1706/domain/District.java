package com.mlz.house1706.domain;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name="tb_district")
public class District implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="distid")
	private Integer id;
	@Column(name="distname",nullable=false)
	private String name;
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	public District() {
	}
	
	public District(String name, City city) {
		this.name = name;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
