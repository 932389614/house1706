package com.mlz.house1706.persistence.impl;

import java.util.List;

import com.mlz.house1706.domain.City;
import com.mlz.house1706.domain.District;
import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.House_Type;
import com.mlz.house1706.domain.Province;
import com.mlz.house1706.domain.User;
import com.mlz.house1706.persistence.HouseDao;
import com.mlz.house1706.util.HibernateUtil;

public class HouseDaoImpl extends BaseDaoAdapter<House, Integer> implements HouseDao {

	@Override
	public List<House> findHouseByUser(User user) {
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.user=:user")
				.setParameter("user", user)
				.getResultList();
	}

	@Override
	public List<House> findHouseByHouse_Type(House_Type house_Type) {

		return HibernateUtil.getSession()
				.createQuery("from House as h where h.house_Type=:house_Type")
				.setParameter("house_Type", house_Type)
				.getResultList();
	}

	@Override
	public List<House> findHouseByDistrict(District district) {
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.district=:district")
				.setParameter("district", district)
				.getResultList();
	}

	@Override
	public List<House> findHouseByCity(City city) {
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.district.city=:city")
				.setParameter("city", city)
				.getResultList();
	}

	@Override
	public List<House> findHouseByProvince(Province province) {
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.district.city.province=:province")
				.setParameter("province", province)
				.getResultList();
	}
	
	@Override
	public List<House> findHouseByPrice(float min, float max) {
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.price>=:min and c.price<=:max")
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}

	@Override
	public List<House> findHouseByHouse_TypeAndDistrict(House_Type house_Type, District district) {
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.house_Type=:house_Type and h.district=:district")
				.setParameter("house_Type", house_Type)
				.setParameter("district", district)
				.getResultList();
	}

	@Override
	public List<House> findHouseByHouse_TypeAndCity(House_Type house_Type, City city) {

		return HibernateUtil.getSession()
				.createQuery("from House as h where h.house_Type=:house_Type and h.district.city=:city")
				.setParameter("house_Type", house_Type)
				.setParameter("city", city)
				.getResultList();
	}

	@Override
	public List<House> findHouseByHouse_TypeAndProvince(House_Type house_Type, Province province) {
		// TODO Auto-generated method stub
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.house_Type=:house_Type and h.district.city.province=:province")
				.setParameter("house_Type", house_Type)
				.setParameter("province", province)
				.getResultList();
	}
	
	@Override
	public List<House> findHouseByHouse_TypeAndPrice(House_Type house_Type, float min, float max) {
		// TODO Auto-generated method stub
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.house_Type=:house_Type and h.price>=:min and h.price<=:max")
				.setParameter("house_Type", house_Type)
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}

	@Override
	public List<House> findHouseByDistrictAndPrice(District district, float min, float max) {

		return HibernateUtil.getSession()
				.createQuery("from House as h where h.district=:district and h.price>=:min and h.price<=:max")
				.setParameter("district", district)
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}
	
	@Override
	public List<House> findHouseByCityAndPrice(City city, float min, float max) {
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.district.city=:city and h.price>=:min and h.price<=:max")
				.setParameter("city", city)
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}

	@Override
	public List<House> findHouseByProvinceAndPrice(Province province, float min, float max) {
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.district.city.province=:province and h.price>=:min and h.price<=:max")
				.setParameter("province", province)
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}


	@Override
	public List<House> findHouseByHouse_TypeAndDistrictAndPrice(House_Type house_Type, District district, float min,
			float max) {
		// TODO Auto-generated method stub
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.house_Type=:house_Type and h.district=:district and h.price>=:min and h.price<=:max")
				.setParameter("house_Type", house_Type)
				.setParameter("district", district)
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}

	@Override
	public List<House> findHouseByHouse_TypeAndCityAndPrice(House_Type house_Type, City city, float min, float max) {

		return HibernateUtil.getSession()
				.createQuery("from House as h where h.house_Type=:house_Type and h.district.city=:city and h.price>=:min and h.price<=:max")
				.setParameter("house_Type", house_Type)
				.setParameter("city", city)
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}

	@Override
	public List<House> findHouseByHouse_TypeAndProvinceAndPrice(House_Type house_Type, Province province, float min,
			float max) {
		// TODO Auto-generated method stub
		return HibernateUtil.getSession()
				.createQuery("from House as h where h.house_Type=:house_Type and h.district.city.province=:province and h.price>=:min and h.price<=:max")
				.setParameter("house_Type", house_Type)
				.setParameter("province", province)
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}

	
}
