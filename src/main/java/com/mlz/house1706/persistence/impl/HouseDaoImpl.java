package com.mlz.house1706.persistence.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mlz.house1706.domain.District;
import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.House_Type;

import com.mlz.house1706.persistence.HouseDao;
import com.mlz.house1706.util.PageBean;

@Repository
public class HouseDaoImpl extends BaseDaoAdapter<House, Integer> implements HouseDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int findHouseCount() {
		
		return 0;
	}
	

	@Override
	public PageBean<House> findHouseByPrice(float minPrice, float maxPrice, int size, int currentPage) {
		List<House> houses=sessionFactory.getCurrentSession()
				.createQuery("from House as h where h.price>=:minPrice and h.price<=:maxPrice")
				.setParameter("minPrice", minPrice)
				.setParameter("maxPrice", maxPrice)
				.setFirstResult((currentPage-1)*size)
				.setMaxResults(size)
				.getResultList();
		int totalPage=(int) sessionFactory.getCurrentSession()
				.createQuery("select count(h) from House as h where h.price>=:minPrice and h.price<=:maxPrice")
				.getSingleResult();
		PageBean<House> pageBean=new PageBean<>(houses, totalPage, currentPage, size);
		return pageBean;
	}

	@Override
	public PageBean<House> findHouseByHoust_Type(House_Type house_Type, int size, int currentPage) {
		List<House> houses=sessionFactory.getCurrentSession()
				.createQuery("from House as h where h.house_Type=:house_Type")
				.setParameter("house_Type", house_Type)
				.setFirstResult((currentPage-1)*size)
				.setMaxResults(size)
				.getResultList();
		int totalPage=(int) sessionFactory.getCurrentSession()
				.createQuery("select count(h) from House as h where h.house_Type=:house_Type")
				.getSingleResult();
		PageBean<House> pageBean=new PageBean<>(houses, totalPage, currentPage, size);
		return pageBean;
	}

	@Override
	public PageBean<House> findHouseByArea(int minArea, int maxArea, int size, int currentPage) {
		List<House> houses=sessionFactory.getCurrentSession()
				.createQuery("from House as h where h.area>=:minArea and h.price<=:maxArea")
				.setParameter("minArea", minArea)
				.setParameter("maxArea", maxArea)
				.setFirstResult((currentPage-1)*size)
				.setMaxResults(size)
				.getResultList();
		int totalPage=(int) sessionFactory.getCurrentSession()
				.createQuery("select count(h) from House as h where h.area>=:minArea and h.price<=:maxArea")
				.getSingleResult();
		PageBean<House> pageBean=new PageBean<>(houses, totalPage, currentPage, size);
		return pageBean;
	}


	@Override
	public PageBean<House> findHouseByAreaAndPrice(float minPrice, float maxPrice, int minArea, int maxArea, int size,
			int currentPage) {
		List<House> houses=sessionFactory.getCurrentSession()
				.createQuery("from House as h where h.price>=:minPrice and h.price<=:maxPrice and h.area>=:minArea and h.price<=:maxArea")
				.setParameter("minPrice", minPrice)
				.setParameter("maxPrice", maxPrice)
				.setParameter("minArea", minArea)
				.setParameter("maxArea", maxArea)
				.setFirstResult((currentPage-1)*size)
				.setMaxResults(size)
				.getResultList();
		int totalPage=(int) sessionFactory.getCurrentSession()
				.createQuery("select count(h) from House as h where h.price>=:minPrice and h.price<=:maxPrice and h.area>=:minArea and h.price<=:maxArea")
				.getSingleResult();
		PageBean<House> pageBean=new PageBean<>(houses, totalPage, currentPage, size);
		return pageBean;
	}


	@Override
	public PageBean<House> findHouseByDistrictAndHouse_Type(District district, House_Type house_Type, int size,
			int currentPage) {
		
		List<House> houses=sessionFactory.getCurrentSession()
				.createQuery("from House as h,District as d,House_Type as ht where h.district=:d.district and h.house_Type=:ht.house_Type and d.id=:did and ht.id=:htid")
				.setParameter("house_Type", house_Type)
				.setParameter("district", district)
				.setParameter("htid", house_Type.getId())
				.setParameter("did", district.getId())
				.setFirstResult((currentPage-1)*size)
				.setMaxResults(size)
				.getResultList();
		int totalPage=(int) sessionFactory.getCurrentSession()
				.createQuery("select count(h) from House as h h.house_Type=:house_Type and h.district=:district")
				.getSingleResult();
		PageBean<House> pageBean=new PageBean<>(houses, totalPage, currentPage, size);
		return pageBean;
	}


	@Override
	public PageBean<House> findByPage(int page, int size) {
		List<House> houses=sessionFactory.getCurrentSession()
				.createQuery("from House as h order by h.pubDate desc")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.getResultList();
		int totalPage=sessionFactory.getCurrentSession()
				.createQuery("select count(h) from House as h",Long.class)
				.getSingleResult().intValue();
		PageBean<House> pageBean=new PageBean<>(houses, totalPage, page, size);
		return pageBean;
	}


}
