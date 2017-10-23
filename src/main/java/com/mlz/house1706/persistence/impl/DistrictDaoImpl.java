package com.mlz.house1706.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mlz.house1706.domain.City;
import com.mlz.house1706.domain.District;
import com.mlz.house1706.persistence.DistrictDao;

@Repository
public class DistrictDaoImpl extends BaseDaoAdapter<District, Integer> implements DistrictDao {

	@Override
	public List<District> findDistrictByCity(City city) {

		return sessionFactory.getCurrentSession().createQuery("from District as c where c.city=:city")
				.setParameter("city", city).getResultList();
	}

}
