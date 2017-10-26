package com.mlz.house1706.service;

import java.util.List;

import com.mlz.house1706.domain.*;
import com.mlz.house1706.util.PageBean;

public interface HouseService {
	List<House_Type> listAllHouse_Types();
	
	boolean publishNewHouse(House house);
	
	PageBean<House> listHousesByPage(int page, int size);
	
	PageBean<House> searchHousesWithParamByPage(SearchHouseParam searchHouseParam,int page, int size);
}
