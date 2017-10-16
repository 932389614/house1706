package com.mlz.house1706.persistence;

import java.util.List;

import com.mlz.house1706.domain.*;


public interface DistrictDao extends BaseDao<District, Integer> {
	List<District> findDistrictByCity(City city);
}
