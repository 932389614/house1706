package com.mlz.house1706.persistence;

import java.util.List;

import com.mlz.house1706.domain.City;
import com.mlz.house1706.domain.Province;

public interface CityDao extends BaseDao<City, Integer> {
	List<City> findCityByProvince(Province province);
}
