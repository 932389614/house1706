package com.mlz.house1706.persistence;

import java.util.List;

import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.House_Photo;

public interface House_PhotoDao extends BaseDao<House_Photo, Integer> {
	List<House_Photo> findHouse_PhotoByHouse(House house);
}
