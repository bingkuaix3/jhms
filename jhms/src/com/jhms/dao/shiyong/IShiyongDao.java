package com.jhms.dao.shiyong;

import java.util.List;

import com.jhms.entity.TShiyongs;

public interface IShiyongDao {
	
	public void save(TShiyongs transientInstance);
	
	public void delete(TShiyongs persistentInstance);
	
	public TShiyongs findById(java.lang.String id);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	
	public TShiyongs merge(TShiyongs detachedInstance);

}
