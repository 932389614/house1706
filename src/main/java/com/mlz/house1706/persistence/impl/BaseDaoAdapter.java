package com.mlz.house1706.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.mlz.house1706.persistence.*;

public abstract class BaseDaoAdapter<E, K extends Serializable> implements BaseDao<E, K> {
	private Class<E> entityType;
	private String entityName;

	@Autowired
	public SessionFactory sessionFactory;

	protected BaseDaoAdapter() {
		// ��ȡ�����͵ĸ���
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		// ͨ�������͵ĸ����ȡ��ʵ�����Ͳ�������
		entityType = (Class<E>) pt.getActualTypeArguments()[0];
		// ��ȡ����������������
		entityName = entityType.getSimpleName();
	}

	@Override
	public K save(E entity) {
		// TODO Auto-generated method stub
		return (K) sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public boolean deleteById(K id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("delete from " + entityName + " as o where o.id=:id")
				.setParameter("id", id).executeUpdate() == 1;
	}

	@Override
	public E update(E entity) {
		return (E) sessionFactory.getCurrentSession().merge(entity);
	}

	@Override
	public E findById(K id) {
		return sessionFactory.getCurrentSession().get(entityType, id);
	}

	@Override
	public List<E> findAll() {
		System.out.println(sessionFactory.getCurrentSession().createQuery("from " + entityName, entityType).getResultList().size());
		return sessionFactory.getCurrentSession().createQuery("from " + entityName, entityType).getResultList();
	}
}
