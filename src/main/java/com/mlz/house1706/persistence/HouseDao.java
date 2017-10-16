package com.mlz.house1706.persistence;

import java.util.List;

import com.mlz.house1706.domain.*;
import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.House_Type;
import com.mlz.house1706.domain.User;

public interface HouseDao extends BaseDao<House, Integer> {
	/**
	 * �����û����ҷ�����Ϣ
	 * @param user �û�ʵ��
	 * @return ���ݼ���
	 */
	List<House> findHouseByUser(User user);
	/**
	 * ���ݷ������Ͳ��ҷ�����Ϣ
	 * @param house_Type ��������ʵ��
	 * @return ���ݼ���
	 */
	List<House> findHouseByHouse_Type(House_Type house_Type);
	/**
	 * ���ݵ�����ѯ
	 * @param district ����ʵ��
	 * @return	���ݼ���
	 */
	List<House> findHouseByDistrict(District district);
	/**
	 * ���ݳ��в�ѯ����
	 * @param city	����ʵ��
	 * @return		���ݼ���
	 */
	List<House> findHouseByCity(City city);
	/**
	 * ����ʡ�в�ѯ����
	 * @param province	ʡ��ʵ��
	 * @return			���ݼ���
	 */
	List<House> findHouseByProvince(Province province);
	/**
	 * ���ݼ۸������ѯ������Ϣ
	 * @param min	�۸���Сֵ
	 * @param max	�۸����ֵ
	 * @return		���ݼ���
	 */
	List<House> findHouseByPrice(float min, float max);
	/**
	 * ���ݷ������ͺ͵�����ѯ������Ϣ
	 * @param house_Type	��������ʵ��
	 * @param district		����ʵ��
	 * @return				���ݼ���
	 */
	List<House> findHouseByHouse_TypeAndDistrict(House_Type house_Type,District district);
	/**
	 * ���ݳ��к����Ͳ�ѯ
	 * @param house_Type	����ʵ��
	 * @param city			����ʵ��
	 * @return
	 */
	List<House> findHouseByHouse_TypeAndCity(House_Type house_Type,City city);
	/**
	 * ����ʡ�к����Ͳ�ѯ
	 * @param house_Type	����ʵ��
	 * @param province		ʡ��ʵ��
	 * @return
	 */
	List<House> findHouseByHouse_TypeAndProvince(House_Type house_Type,Province province);
	/**
	 * ���ݼ۸�ͷ������Ͳ�ѯ����	
	 * @param house_Type	��������ʵ��
	 * @param min			�۸���Сֵ
	 * @param max			�۸����ֵ	
	 * @return				���ݼ���
	 */
	List<House> findHouseByHouse_TypeAndPrice(House_Type house_Type,float min, float max);
	/**
	 * ���ݵ����ͼ۸��ѯ����
	 * @param district	����ʵ��
	 * @param min		�۸���Сֵ
	 * @param max		�۸����ֵ
	 * @return			���ݼ���
	 */
	List<House> findHouseByDistrictAndPrice(District district,float min, float max);
	/**
	 * ���ݳ��кͼ۸��ѯ
	 * @param city	����ʵ��
	 * @param min	�۸���Сֵ
	 * @param max	�۸����ֵ
	 * @return
	 */
	List<House> findHouseByCityAndPrice(City city,float min, float max);
	/**
	 * ����ʡ�кͼ۸��ѯ
	 * @param province	ʡ��ʵ��
	 * @param min		�۸���Сֵ
	 * @param max		�۸����ֵ
	 * @return
	 */
	List<House> findHouseByProvinceAndPrice(Province province,float min, float max);
	/**
	 * �������͡������ͼ۸��ѯ����
	 * @param house_Type	����ʵ��
	 * @param district		����ʵ��
	 * @param min			�۸���Сֵ
	 * @param max			�۸����ֵ
	 * @return				���ݼ���
	 */
	List<House> findHouseByHouse_TypeAndDistrictAndPrice(House_Type house_Type,District district,float min, float max);
	/**
	 * �������͡����кͼ۸��ѯ����
	 * @param house_Type	����ʵ��
	 * @param city			����ʵ��
	 * @param min			�۸���Сֵ
	 * @param max			�۸����ֵ
	 * @return				���ݼ���
	 */
	List<House> findHouseByHouse_TypeAndCityAndPrice(House_Type house_Type,City city,float min, float max);
	/**
	 * �������͡�ʡ�кͼ۸��ѯ����
	 * @param house_Type	����ʵ��
	 * @param province		ʡ��ʵ��
	 * @param min			�۸���Сֵ
	 * @param max			�۸����ֵ
	 * @return				���ݼ���
	 */
	List<House> findHouseByHouse_TypeAndProvinceAndPrice(House_Type house_Type,Province province,float min, float max);
}
