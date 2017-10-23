package com.mlz.house1706.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "tb_house")
public class House implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "houseid")
	private Integer id;

	private Integer area;


	private String detail;
	private Integer floor;

	private Float price;
	private Date pubDate;
	
	@Embedded
	private Contacter contacter;
	private String mainPhoto;
	@OneToMany(mappedBy="house")
	private List<House_Photo> otherPhotos;
	private String street;
	private String title;
	private Integer totalFloor;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;
	@ManyToOne
	@JoinColumn(name = "house_type_id")
	private House_Type house_Type;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public House() {
	}
	public House(Integer id) {
		this.id=id;
	}
	

	public House(Integer id, Integer area, String detail, Integer floor, Float price, Date pubDate, Contacter contacter,
			String mainPhoto, List<House_Photo> otherPhotos, String street, String title, Integer totalFloor,
			District district, House_Type house_Type, User user) {
		this.id = id;
		this.area = area;
		this.detail = detail;
		this.floor = floor;
		this.price = price;
		this.pubDate = pubDate;
		this.contacter = contacter;
		this.mainPhoto = mainPhoto;
		this.otherPhotos = otherPhotos;
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


	public Contacter getContacter() {
		return contacter;
	}
	public List<House_Photo> getOtherPhotos() {
		return otherPhotos;
	}
	public void setContacter(Contacter contacter) {
		this.contacter = contacter;
	}
	public void setOtherPhotos(List<House_Photo> otherPhotos) {
		this.otherPhotos = otherPhotos;
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
		return "House [id=" + id + ", area=" + area + ", detail=" + detail + ", floor=" + floor + ", price=" + price
				+ ", pubDate=" + pubDate + ", contacter=" + contacter + ", mainPhoto=" + mainPhoto + ", otherPhotos="
				+ otherPhotos + ", street=" + street + ", title=" + title + ", totalFloor=" + totalFloor + ", district="
				+ district + ", house_Type=" + house_Type + ", user=" + user + "]";
	}

	

}
