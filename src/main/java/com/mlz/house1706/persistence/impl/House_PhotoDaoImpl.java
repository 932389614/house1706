package com.mlz.house1706.persistence.impl;

import java.util.List;

import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.House_Photo;
import com.mlz.house1706.persistence.House_PhotoDao;
import com.mlz.house1706.util.HibernateUtil;

public class House_PhotoDaoImpl extends BaseDaoAdapter<House_Photo, Integer> implements House_PhotoDao {
	
	@Override
	public List<House_Photo> findHouse_PhotoByHouse(House house) {
		return HibernateUtil.getSession().createQuery("from House_Photo as c where c.house=:house")
				.setParameter("house", house).getResultList();
	}

}
