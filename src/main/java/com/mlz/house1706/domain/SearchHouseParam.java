package com.mlz.house1706.domain;

public class SearchHouseParam {
	private String title;
	private String price;
	private House_Type house_Type;
	private String area;
	
	
	public SearchHouseParam() {
		super();
	}
	public SearchHouseParam(String title, String price, House_Type house_Type, String area) {
		super();
		this.title = title;
		this.price = price;
		this.house_Type = house_Type;
		this.area = area;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getMinPrice() {
		return this.price.equals("不限")?0f:Float.parseFloat(this.price.split("-")[0]);
	}
	public Float getMaxPrice() {
		return this.price.equals("不限")?Float.MAX_VALUE:Float.parseFloat(this.price.split("-")[1]);		
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public House_Type getHouse_Type() {
		return house_Type;
	}
	public void setHouse_Type(House_Type house_Type) {
		this.house_Type = house_Type;
	}
	public Integer getMinArea() {
		return this.area.equals("不限")?0:Integer.parseInt(this.area.split("-")[0]);	
	}
	public Integer getMaxArea() {
		return this.area.equals("不限")?Integer.MAX_VALUE:Integer.parseInt(this.area.split("-")[1]);
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "SearchHouseParam [title=" + title + ", price=" + price + ", house_Type=" + house_Type + ", area=" + area
				+ "]";
	}
}
