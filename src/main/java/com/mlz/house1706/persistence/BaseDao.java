package com.mlz.house1706.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * ͨ�õ����ݷ��ʽӿ�
 * 
 * @author Administrator
 *
 * @param <E>����ʵ������
 * @param <K>��ʶ�ֶ�����
 */
public interface BaseDao<E, K extends Serializable> {
	/**
	 * ����
	 * 
	 * @return
	 */
	K save(E entity);

	/**
	 * ɾ��
	 * 
	 * @return
	 */
	boolean deleteById(K id);

	/**
	 * ����
	 * 
	 * @return
	 */
	E update(E entity);

	/**
	 * ��ѯ
	 * 
	 * @param id
	 * @return
	 */
	E findById(K id);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	List<E> findAll();
}
