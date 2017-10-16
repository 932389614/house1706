package com.mlz.house1706.persistence.impl;

import java.util.List;

import com.mlz.house1706.domain.City;
import com.mlz.house1706.domain.Province;
import com.mlz.house1706.persistence.CityDao;
import com.mlz.house1706.util.HibernateUtil;

public class CityDaoImpl extends BaseDaoAdapter<City, Integer> implements CityDao {

	@Override
	public List<City>  findCityByProvince(Province province) {
		
		return HibernateUtil.getSession().createQuery("from City as c where c.province=:province")
				.setParameter("province", province).getResultList();
	}

	
}
