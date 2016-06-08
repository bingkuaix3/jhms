package com.jhms.dao.solution;

import java.util.List;

import com.jhms.entity.TSolutions;

public interface ISolutionDao {
	
	public void save(TSolutions transientInstance);
	
	public void delete(TSolutions persistentInstance);
	
	public TSolutions findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TSolutions merge(TSolutions detachedInstance);

}
