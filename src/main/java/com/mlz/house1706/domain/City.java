package com.mlz.house1706.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tb_city")
public class City implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cityid")
	private Integer id;
	@Column(name = "cityname")
	private String name;
	@ManyToOne
	@JoinColumn(name = "prov_id")
	private Province province;

	public City() {
	}

	public City(String name, Province province) {
		this.name = name;
		this.province = province;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Province getProvince() {
		return province;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}
