package com.mlz.house1706.service.impl;


import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.House_Type;
import com.mlz.house1706.domain.SearchHouseParam;
import com.mlz.house1706.mappers.HouseMapper;
import com.mlz.house1706.persistence.HouseDao;
import com.mlz.house1706.persistence.House_TypeDao;
import com.mlz.house1706.service.HouseService;
import com.mlz.house1706.util.HqlQueryBean;
import com.mlz.house1706.util.PageBean;
import com.mlz.house1706.util.QueryBean;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseDao houseDao;
	
	@Autowired
	private House_TypeDao house_TypeDao;
	@Autowired
	private HouseMapper houseMapper;
	@Override
	public List<House_Type> listAllHouse_Types() {
		return house_TypeDao.findAll();
	}

	@Override
	public boolean publishNewHouse(House house) {
		// TODO Auto-generated method stub
		return houseDao.save(house)!=null;
	}

	@Override
	public PageBean<House> listHousesByPage(int page, int size) {
		
		return houseDao.findByPage(page, size);
	}

	@Override
	public PageBean<House> searchHousesWithParamByPage(SearchHouseParam searchHouseParam, int page, int size) {
		System.out.println(searchHouseParam);
		QueryBean queryBean=new HqlQueryBean(House.class);
		queryBean.addCondition("title like ?", "%"+searchHouseParam.getTitle()+"%")
			.addCondition(searchHouseParam.getHouse_Type().getId()!=0,"house_Type=?", searchHouseParam.getHouse_Type())
			.addCondition("area>=?", searchHouseParam.getMinArea())
			.addCondition("area<=?", searchHouseParam.getMaxArea())
			.addCondition("price>=?", searchHouseParam.getMinPrice())
			.addCondition("price<=?", searchHouseParam.getMaxPrice())
			.addOrderBy("pubDate", false);
		System.out.println(queryBean.getQueryString());
		return houseDao.findByQueryAndPage(queryBean, page, size);
	}

	
}
