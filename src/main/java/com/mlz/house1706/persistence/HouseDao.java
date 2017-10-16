package com.mlz.house1706.persistence;

import java.util.List;

import com.mlz.house1706.domain.*;
import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.House_Type;
import com.mlz.house1706.domain.User;

public interface HouseDao extends BaseDao<House, Integer> {
	/**
	 * 根据用户查找房屋信息
	 * @param user 用户实体
	 * @return 房屋集合
	 */
	List<House> findHouseByUser(User user);
	/**
	 * 根据房屋类型查找房屋信息
	 * @param house_Type 房屋类型实体
	 * @return 房屋集合
	 */
	List<House> findHouseByHouse_Type(House_Type house_Type);
	/**
	 * 根据地区查询
	 * @param district 地区实体
	 * @return	房屋集合
	 */
	List<House> findHouseByDistrict(District district);
	/**
	 * 根据城市查询房屋
	 * @param city	城市实体
	 * @return		房屋集合
	 */
	List<House> findHouseByCity(City city);
	/**
	 * 根据省市查询房屋
	 * @param province	省市实体
	 * @return			房屋集合
	 */
	List<House> findHouseByProvince(Province province);
	/**
	 * 根据价格区间查询房屋信息
	 * @param min	价格最小值
	 * @param max	价格最大值
	 * @return		房屋集合
	 */
	List<House> findHouseByPrice(float min, float max);
	/**
	 * 根据房屋类型和地区查询房屋信息
	 * @param house_Type	房屋类型实体
	 * @param district		地区实体
	 * @return				房屋集合
	 */
	List<House> findHouseByHouse_TypeAndDistrict(House_Type house_Type,District district);
	/**
	 * 根据城市和类型查询
	 * @param house_Type	类型实体
	 * @param city			城市实体
	 * @return
	 */
	List<House> findHouseByHouse_TypeAndCity(House_Type house_Type,City city);
	/**
	 * 根据省市和类型查询
	 * @param house_Type	类型实体
	 * @param province		省市实体
	 * @return
	 */
	List<House> findHouseByHouse_TypeAndProvince(House_Type house_Type,Province province);
	/**
	 * 根据价格和房屋类型查询房屋	
	 * @param house_Type	房屋类型实体
	 * @param min			价格最小值
	 * @param max			价格最大值	
	 * @return				房屋集合
	 */
	List<House> findHouseByHouse_TypeAndPrice(House_Type house_Type,float min, float max);
	/**
	 * 根据地区和价格查询房屋
	 * @param district	地区实体
	 * @param min		价格最小值
	 * @param max		价格最大值
	 * @return			房屋集合
	 */
	List<House> findHouseByDistrictAndPrice(District district,float min, float max);
	/**
	 * 根据城市和价格查询
	 * @param city	城市实体
	 * @param min	价格最小值
	 * @param max	价格最大值
	 * @return
	 */
	List<House> findHouseByCityAndPrice(City city,float min, float max);
	/**
	 * 根据省市和价格查询
	 * @param province	省市实体
	 * @param min		价格最小值
	 * @param max		价格最大值
	 * @return
	 */
	List<House> findHouseByProvinceAndPrice(Province province,float min, float max);
	/**
	 * 根据类型、地区和价格查询房屋
	 * @param house_Type	类型实体
	 * @param district		地区实体
	 * @param min			价格最小值
	 * @param max			价格最大值
	 * @return				房屋集合
	 */
	List<House> findHouseByHouse_TypeAndDistrictAndPrice(House_Type house_Type,District district,float min, float max);
	/**
	 * 根据类型、城市和价格查询房屋
	 * @param house_Type	类型实体
	 * @param city			城市实体
	 * @param min			价格最小值
	 * @param max			价格最大值
	 * @return				房屋集合
	 */
	List<House> findHouseByHouse_TypeAndCityAndPrice(House_Type house_Type,City city,float min, float max);
	/**
	 * 根据类型、省市和价格查询房屋
	 * @param house_Type	类型实体
	 * @param province		省市实体
	 * @param min			价格最小值
	 * @param max			价格最大值
	 * @return				房屋集合
	 */
	List<House> findHouseByHouse_TypeAndProvinceAndPrice(House_Type house_Type,Province province,float min, float max);
}
