package com.mlz.house1706.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tb_house_photo")
public class House_Photo implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="photoid")
	private Integer id;
	@Column(name="photoname",nullable=false)
	private String name;
	@ManyToOne
	@JoinColumn(name="house_id")
	private House house;
	public House_Photo() {
	}
	public House_Photo(String name, House house) {
		this.name = name;
		this.house = house;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public House getHouse() {
		return house;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	
	
	
}
