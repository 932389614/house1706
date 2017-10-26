package com.mlz.house1706.persistence;

import java.util.List;

import com.mlz.house1706.domain.*;
import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.House_Type;
import com.mlz.house1706.domain.User;
import com.mlz.house1706.util.PageBean;
import com.mlz.house1706.util.QueryBean;

public interface HouseDao extends BaseDao<House, Integer> {
	int findHouseCount();
	
	PageBean<House> findHouseByPrice(float minPrice,float maxPrice,int size,int currentPage); 
	
	PageBean<House> findHouseByHoust_Type(House_Type house_Type,int size,int currentPage); 
	
	PageBean<House> findHouseByArea(int minArea,int maxArea,int size,int currentPage); 
	
	PageBean<House> findHouseByAreaAndPrice(float minPrice,float maxPrice,int minArea,int maxArea,int size,int currentPage); 
	
	PageBean<House> findHouseByDistrictAndHouse_Type(District district,House_Type house_Type,int size,int currentPage);
	
	PageBean<House> findByPage(int page,int size);
	
	PageBean<House> findByQueryAndPage(QueryBean queryBean, int page,int size);
	
}
