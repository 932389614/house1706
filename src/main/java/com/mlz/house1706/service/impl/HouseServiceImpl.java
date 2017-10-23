package com.mlz.house1706.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mlz.house1706.domain.City;
import com.mlz.house1706.domain.District;
import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.House_Type;
import com.mlz.house1706.domain.Province;
import com.mlz.house1706.domain.User;
import com.mlz.house1706.persistence.HouseDao;
import com.mlz.house1706.persistence.House_TypeDao;
import com.mlz.house1706.service.HouseService;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseDao houseDao;
	
	@Autowired
	private House_TypeDao house_TypeDao;
	
	@Override
	public List<House_Type> listAllHouse_Types() {
		return house_TypeDao.findAll();
	}

	@Override
	public boolean publishNewHouse(House house) {
		// TODO Auto-generated method stub
		return houseDao.save(house)!=null;
	}

}
