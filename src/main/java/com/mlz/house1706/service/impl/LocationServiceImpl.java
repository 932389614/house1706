package com.mlz.house1706.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mlz.house1706.domain.City;
import com.mlz.house1706.domain.District;
import com.mlz.house1706.domain.Province;
import com.mlz.house1706.persistence.CityDao;
import com.mlz.house1706.persistence.DistrictDao;
import com.mlz.house1706.persistence.ProvinceDao;
import com.mlz.house1706.service.LocationService;

@Service
@Transactional(readOnly=true)
public class LocationServiceImpl implements LocationService {
	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private DistrictDao districtDao;
	@Override
	public List<Province> listAllProvinces() {
		return provinceDao.findAll();
	}

	@Override
	public List<City> listAllCitiesByProvince(Province province) {
		return cityDao.findCityByProvince(province);
	}

	@Override      
	public List<District> listAllDistrictByCity(City city) {
		// TODO Auto-generated method stub
		return districtDao.findDistrictByCity(city);
	}

}
