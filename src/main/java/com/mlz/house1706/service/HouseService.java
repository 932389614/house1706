package com.mlz.house1706.service;

import java.util.List;

import com.mlz.house1706.domain.*;

public interface HouseService {
	List<House_Type> listAllHouse_Types();
	
	boolean publishNewHouse(House house);
}
