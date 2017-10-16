package com.mlz.house1706.persistence.impl;

import java.util.List;

import com.mlz.house1706.domain.City;
import com.mlz.house1706.domain.District;
import com.mlz.house1706.persistence.DistrictDao;
import com.mlz.house1706.util.HibernateUtil;

public class DistrictDaoImpl extends BaseDaoAdapter<District, Integer> implements DistrictDao {

	@Override
	public List<District> findDistrictByCity(City city) {
		
		return HibernateUtil.getSession().createQuery("from District as c where c.city=:city")
				.setParameter("city", city).getResultList();
	}

	
}
