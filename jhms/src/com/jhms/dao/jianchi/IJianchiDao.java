package com.jhms.dao.jianchi;

import java.util.List;

import com.jhms.entity.TJianchis;

public interface IJianchiDao {
	
	public void save(TJianchis transientInstance);
	
	public void delete(TJianchis persistentInstance);
	
	public TJianchis findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TJianchis merge(TJianchis detachedInstance);

}
