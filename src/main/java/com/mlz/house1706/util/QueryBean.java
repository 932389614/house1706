package com.mlz.house1706.util;

import java.util.List;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

public interface QueryBean {
	
	
	/**
	 * 添加排序条件
	 * @param flag
	 * @param keyword
	 * @param asc
	 */
	QueryBean addOrderBy(boolean flag,String keyword,boolean asc);
	
	default QueryBean addOrderBy(String keyword,boolean asc) {		
		return addOrderBy(true,keyword,asc);
	};
	
	default QueryBean addOrderBy(String keyword){		
		return addOrderBy(keyword,true);
	};
	/**
	 * 返回对象本身可以实现级联变成
	 * @param flag
	 * @param condition
	 * @param value
	 * @return
	 */
	QueryBean addCondition(boolean flag,String condition,Object value);
	
	default QueryBean addCondition(String condition,Object value) {
		return addCondition(true,condition,value);
	};
	/**
	 * 获取查询语句
	 * @return
	 */
	String getQueryString();
	/**
	 * 获取查询记录数
	 * @return
	 */
	String getCountString();
	/**
	 * 获得查询参数
	 * @return
	 */
	List<Object> getParameters();
}
