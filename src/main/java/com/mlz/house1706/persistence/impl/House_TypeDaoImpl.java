package com.mlz.house1706.persistence.impl;

import org.springframework.stereotype.Repository;

import com.mlz.house1706.domain.House_Type;
import com.mlz.house1706.persistence.House_TypeDao;

@Repository
public class House_TypeDaoImpl extends BaseDaoAdapter<House_Type, Integer> implements House_TypeDao {

}
