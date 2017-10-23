package com.mlz.house1706.service;

import java.util.List;

import com.mlz.house1706.domain.City;
import com.mlz.house1706.domain.District;
import com.mlz.house1706.domain.Province;

public interface LocationService {
	/**
	 * 列出所有省市
	 * @return
	 */
	List<Province> listAllProvinces();
	/**
	 * 列出所有城市
	 * @param province
	 * @return
	 */
	List<City> listAllCitiesByProvince(Province province);
	/**
	 * 列出所有地区
	 * @param city
	 * @return
	 */
	List<District> listAllDistrictByCity(City city);
	
}
