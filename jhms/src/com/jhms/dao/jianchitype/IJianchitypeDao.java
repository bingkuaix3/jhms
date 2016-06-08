package com.jhms.dao.jianchitype;

import java.util.List;

import com.jhms.entity.TJianchitypes;

public interface IJianchitypeDao {

	public void save(TJianchitypes transientInstance);
	
	public void delete(TJianchitypes persistentInstance);
	
	public TJianchitypes findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TJianchitypes merge(TJianchitypes detachedInstance);
}
