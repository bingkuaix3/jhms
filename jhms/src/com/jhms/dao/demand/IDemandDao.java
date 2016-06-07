package com.jhms.dao.demand;

import java.util.List;

import com.jhms.entity.TDemands;

public interface IDemandDao {
	
	public void save(TDemands transientInstance);
	
	public void delete(TDemands persistentInstance);
	
	public TDemands findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TDemands merge(TDemands detachedInstance);

}
