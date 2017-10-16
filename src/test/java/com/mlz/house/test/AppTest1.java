package com.mlz.house.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.mlz.house1706.domain.*;
import com.mlz.house1706.persistence.CityDao;
import com.mlz.house1706.persistence.DistrictDao;
import com.mlz.house1706.persistence.HouseDao;
import com.mlz.house1706.persistence.House_TypeDao;
import com.mlz.house1706.persistence.ProvinceDao;
import com.mlz.house1706.persistence.UserDao;
import com.mlz.house1706.persistence.impl.CityDaoImpl;
import com.mlz.house1706.persistence.impl.DistrictDaoImpl;
import com.mlz.house1706.persistence.impl.HouseDaoImpl;
import com.mlz.house1706.persistence.impl.House_PhotoDaoImpl;
import com.mlz.house1706.persistence.impl.House_TypeDaoImpl;
import com.mlz.house1706.persistence.impl.ProvinceDaoImpl;
import com.mlz.house1706.persistence.impl.UserDaoImpl;
import com.mlz.house1706.util.HibernateUtil;


public class AppTest1 {
	@Test
	public void testLogin() {
		Session session =HibernateUtil.getSession();
		session.beginTransaction();
		House house =session.get(House.class, 1);
		House_Type house_Type=session.get(House_Type.class, 1);
		House_Photo house_Photo=session.get(House_Photo.class, 1);
		System.out.println(house);
		System.out.println(house_Type);
		System.out.println(house_Photo);
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void testSave() {
		Session session =HibernateUtil.getSession();
		session.beginTransaction();
		
		UserDao userDao=new UserDaoImpl();
		ProvinceDao provinceDao=new ProvinceDaoImpl();
		CityDao cityDao=new CityDaoImpl();
		DistrictDao districtDao=new DistrictDaoImpl();
		House_TypeDao house_TypeDao=new House_TypeDaoImpl();
		HouseDao houseDao=new HouseDaoImpl();
		
		List<User> users=userDao.findAll();
		List<House_Type> house_Types=house_TypeDao.findAll();
		List<Province> provinces=provinceDao.findAll();
		List<City> cities=cityDao.findAll();
		List<District> districts=districtDao.findAll();
		List<House> houses=houseDao.findAll();
		for(District district:districts) {
			for(House_Type house_Type:house_Types) {
			House house=new House(102,"123456789@qq.com","买到就是赚到","123456789","18323294150","百平精品房",3,
					null,100000f,new Date(),"跳伞塔","90万精品房，买到就是赚到",32,
					district,house_Type,users.get(0));
			session.save(house);
			}
		}
	}
		@Test
		public void testUpdate() {
			Session session =HibernateUtil.getSession();
			session.beginTransaction();
			
			HouseDao houseDao=new HouseDaoImpl();
			
	
			List<House> houses=houseDao.findAll();
			for(int i=0;i<houses.size();i++) {
				houses.get(i).setPrice(i*100000f+100000);
			}
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() {
		Session session =HibernateUtil.getSession();
		session.beginTransaction();
		
		UserDao userDao=new UserDaoImpl();
		ProvinceDao provinceDao=new ProvinceDaoImpl();
		CityDao cityDao=new CityDaoImpl();
		DistrictDao districtDao=new DistrictDaoImpl();
		House_TypeDao house_TypeDao=new House_TypeDaoImpl();
		HouseDao houseDao=new HouseDaoImpl();
		
		List<User> users=userDao.findAll();
		List<House_Type> house_Types=house_TypeDao.findAll();
		List<Province> provinces=provinceDao.findAll();
		List<City> cities=cityDao.findAll();
		List<District> districts=districtDao.findAll();
		List<House> houses=houseDao.findAll();
		
		System.out.println("users"+users.size());
		System.out.println("house_Types"+house_Types.size());
		System.out.println("provinces"+provinces.size());
		System.out.println("cities"+cities.size());
		System.out.println("districts"+districts.size());
		System.out.println("houses"+houses.size());
		System.out.println("findHouseByDistrict");
		for(int i=0;i<districts.size();i++) {
			List<House> house=houseDao.findHouseByDistrict(districts.get(i));
			System.out.println(house.size());
		}
		System.out.println("findHouseByCity");
		for(int i=0;i<cities.size();i++) {
			List<House> house=houseDao.findHouseByCity(cities.get(i));
			System.out.print(house.size()+" ");
		}
		System.out.print("findHouseByProvince"+" ");
		for(int i=0;i<provinces.size();i++) {
			
			List<House> house=houseDao.findHouseByProvince(provinces.get(i));
			System.out.print(house.size()+" ");
		}
		
		
		
		System.out.println("findHouseByDistrictAndPrice");
		for(int i=0;i<districts.size();i++) {
			List<House> house=houseDao.findHouseByDistrictAndPrice(districts.get(i),300000f,1200000f);
			System.out.println(house.size());
		}
		System.out.println("findHouseByCityAndPrice");
		for(int i=0;i<cities.size();i++) {
			List<House> house=houseDao.findHouseByCityAndPrice(cities.get(i),1200000f,2200000f);
			System.out.println(house.size());
		}
		System.out.println("findHouseByProvinceAndPrice");
		for(int i=0;i<provinces.size();i++) {
			List<House> house=houseDao.findHouseByProvinceAndPrice(provinces.get(i),0,2200000f);
			System.out.println(house.size());
		}
		
		
		System.out.println("findHouseByHouse_TypeAndDistrict");
		for(int i=0;i<districts.size();i++) {
			System.out.println(districts.get(i).getName());
			for(int j=0;j<house_Types.size();j++) {
				System.out.print(house_Types.get(j).getName());
				List<House> house=houseDao.findHouseByHouse_TypeAndDistrict(house_Types.get(j)
						,districts.get(i));
				System.out.print(house.size()+" ");
			}
			System.out.println();
		}
		System.out.println("findHouseByHouse_TypeAndCity");
		for(int i=0;i<cities.size();i++) {
			System.out.println(cities.get(i).getName());
			for(int j=0;j<house_Types.size();j++) {
				System.out.print(house_Types.get(j).getName());
				List<House> house=houseDao.findHouseByHouse_TypeAndCity(house_Types.get(j)
						,cities.get(i));
				System.out.print(house.size()+" ");
			}
			System.out.println();
		}
		System.out.println("findHouseByHouse_TypeAndProvince");
		for(int i=0;i<provinces.size();i++) {
			System.out.println(provinces.get(i).getName());
			for(int j=0;j<house_Types.size();j++) {
				System.out.print(house_Types.get(j).getName());
				List<House> house=houseDao.findHouseByHouse_TypeAndProvince(house_Types.get(j)
						,provinces.get(i));
				System.out.print(house.size()+" ");
			}
			System.out.println();
		}
		
		
		
		
		session.getTransaction().commit();
		session.close();
	}
}
