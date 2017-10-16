package com.mlz.house1706.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name="tb_house")
public class House implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="houseid")
	private Integer id;
	@Column(nullable=false)
	private Integer area;
	@Column(name="contacterEmail",length=50)
	private String email;
	@Column(name="contacterName",nullable=false,length=10)
	private String name;
	@Column(name="contacterQQ",length=12)
	private String qq;
	@Column(name="contacterTel",nullable=false,length=20)
	private String tel;
	@Column(length=200)
	private String detail;
	private Integer floor;
	private String mainPhoto;
	@Column(nullable=false)
	private Float price;
	private Date pubDate;
	@Column(nullable=false)	
	private String street;
	@Column(nullable=false,length=50)
	private String title;	
	private Integer totalFloor;
	
	@ManyToOne
	@JoinColumn(name="district_id")
	private District district;
	@ManyToOne
	@JoinColumn(name="house_type_id")
	private House_Type house_Type;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	public House() {
	}
	public House(Integer area, String email, String name, String qq, String tel, String detail, Integer floor,
			String mainPhoto, Float price, Date pubDate, String street, String title, Integer totalFloor,
			District district, House_Type house_Type, User user) {
		this.area = area;
		this.email = email;
		this.name = name;
		this.qq = qq;
		this.tel = tel;
		this.detail = detail;
		this.floor = floor;
		this.mainPhoto = mainPhoto;
		this.price = price;
		this.pubDate = pubDate;
		this.street = street;
		this.title = title;
		this.totalFloor = totalFloor;
		this.district = district;
		this.house_Type = house_Type;
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public Integer getArea() {
		return area;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getQq() {
		return qq;
	}
	public String getTel() {
		return tel;
	}
	public String getDetail() {
		return detail;
	}
	public Integer getFloor() {
		return floor;
	}
	public String getMainPhoto() {
		return mainPhoto;
	}
	public Float getPrice() {
		return price;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public String getStreet() {
		return street;
	}
	public String getTitle() {
		return title;
	}
	public Integer getTotalFloor() {
		return totalFloor;
	}
	public District getDistrict() {
		return district;
	}
	public House_Type getHouse_Type() {
		return house_Type;
	}
	public User getUser() {
		return user;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public void setMainPhoto(String mainPhoto) {
		this.mainPhoto = mainPhoto;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setTotalFloor(Integer totalFloor) {
		this.totalFloor = totalFloor;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public void setHouse_Type(House_Type house_Type) {
		this.house_Type = house_Type;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", area=" + area + ", email=" + email + ", name=" + name + ", qq=" + qq + ", tel="
				+ tel + ", detail=" + detail + ", floor=" + floor + ", mainPhoto=" + mainPhoto + ", price=" + price
				+ ", pubDate=" + pubDate + ", street=" + street + ", title=" + title + ", totalFloor=" + totalFloor
				+ ", district=" + district + ", house_Type=" + house_Type + ", user=" + user + "]";
	}
	
}
