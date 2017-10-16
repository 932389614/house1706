package com.mlz.house1706.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hibernate工具�?
 * @author Administrator
 *
 */
public final class HibernateUtil {
	private static SessionFactory sessionFactory;
	static {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	private HibernateUtil() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 获取与当前线程绑定的session对象
	 * @return
	 */
	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
