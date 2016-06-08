package com.jhms.dao.zhanshi;

import java.util.List;

import com.jhms.entity.TZhanshis;

public interface IZhanshiDao {
	
	public void save(TZhanshis transientInstance);
	
	public void delete(TZhanshis persistentInstance);
	
	public TZhanshis findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TZhanshis merge(TZhanshis detachedInstance);

}
