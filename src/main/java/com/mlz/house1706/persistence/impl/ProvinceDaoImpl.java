package com.mlz.house1706.persistence.impl;

import org.springframework.stereotype.Repository;

import com.mlz.house1706.domain.Province;
import com.mlz.house1706.persistence.ProvinceDao;

@Repository
public class ProvinceDaoImpl extends BaseDaoAdapter<Province, Integer> implements ProvinceDao {

}
